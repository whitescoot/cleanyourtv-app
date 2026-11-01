package tv.cleanyour.core.spec

import kotlinx.serialization.json.JsonPrimitive
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

// The prayer-times switch and the JAKIM zone list: what a Look writes for them, and that the list
// is well formed (codes are what PrayerTimes.java's zone check accepts: three letters, two digits).
class PrayerZonesTest {
    @Test fun everyZoneIsAWellFormedUniqueCode() {
        val codes = PrayerZones.ALL.map { it.code }
        assertEquals(codes.size, codes.toSet().size, "no code twice")
        for (c in codes) assertTrue(Regex("[A-Z]{3}[0-9]{2}").matches(c), c)
        assertTrue(PrayerZones.isValid(PrayerZones.DEFAULT))
        assertEquals(14, PrayerZones.BY_STATE.size, "13 states and the federal territories, as e-Solat groups them")
    }

    @Test fun codesAreLooselyReadButStrictlyListed() {
        assertEquals("TRG04", PrayerZones.of(" trg04 ")?.code)
        assertNull(PrayerZones.of("XXX99"))
        assertNull(PrayerZones.of(null))
        assertFalse(PrayerZones.isValid(""))
    }

    @Test fun offWritesNothingAndOnWritesTheZone() {
        assertEquals(emptyMap(), LookExtrasKeys.keys(LookExtras()))
        assertEquals(emptyMap(), LookExtrasKeys.keys(LookExtras(prayer = false, prayerZone = "SGR01")), "off keeps the zone but writes nothing")
        assertEquals(
            mapOf("prayer_zone" to JsonPrimitive("SGR01")),
            LookExtrasKeys.keys(LookExtras(prayer = true, prayerZone = "sgr01")),
        )
        assertEquals(emptyMap(), LookExtrasKeys.keys(LookExtras(prayer = true, prayerZone = "NOPE1")), "an unknown zone is never sent")
    }

    @Test fun theKeysReadBackAsTheSwitch() {
        val doc = LauncherConfigDoc(unknown = LookExtrasKeys.keys(LookExtras(prayer = true, prayerZone = "JHR02")))
        val shown = LookExtrasKeys.shown(doc)
        assertTrue(shown.prayer)
        assertEquals("JHR02", shown.prayerZone)
        val off = LookExtrasKeys.shown(LauncherConfigDoc())
        assertFalse(off.prayer)
        assertEquals(PrayerZones.DEFAULT, off.prayerZone)
    }

    @Test fun theCodecCarriesBothKeysWithoutWarning() {
        val doc = LauncherConfigDoc(unknown = LookExtrasKeys.keys(LookExtras(prayer = true, prayerZone = "WLY01")))
        val ok = LauncherConfigCodec.decode(LauncherConfigCodec.encode(doc))
        assertTrue(ok is DecodeResult.Ok)
        assertEquals(emptyList(), (ok as DecodeResult.Ok).warnings)
        assertEquals(doc, ok.doc)
    }
}
