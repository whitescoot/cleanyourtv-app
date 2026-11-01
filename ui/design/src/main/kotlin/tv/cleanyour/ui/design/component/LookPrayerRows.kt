package tv.cleanyour.ui.design.component

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import tv.cleanyour.core.flows.LookEdit
import tv.cleanyour.core.spec.PrayerZones
import tv.cleanyour.ui.design.R

// Prayer times on the TV's home screen (JAKIM e-Solat): a switch, and when it is on, the zone as
// e-Solat names them, opened as a list of the states with their zones. Both go to the TV as the
// extra prayer_zone (LookExtrasKeys.keys); the TV downloads the year's times once
// from e-solat.gov.my and keeps them, so the phone needs no internet for this.
@Composable
internal fun LookPrayerRows(x: ExtraRows, onEdit: (LookEdit) -> Unit) {
    if (!x.prayer) return
    val e = x.acting
    var open by rememberSaveable { mutableStateOf(false) }
    LookSection(stringResource(R.string.cyt_look_more_prayer))
    ListGroup(Modifier.padding(bottom = 4.dp)) {
        LookSwitchRow(
            stringResource(R.string.cyt_look_prayer), e.prayer, { on -> x.edit(onEdit) { copy(prayer = on) } },
            description = stringResource(R.string.cyt_look_prayer_desc),
        )
        if (e.prayer) {
            ListDivider()
            val zone = PrayerZones.of(e.prayerZone) ?: PrayerZones.of(PrayerZones.DEFAULT)!!
            ListRow(
                stringResource(R.string.cyt_look_prayer_zone), subtitle = "${zone.code} · ${zone.areas}",
                onClick = { open = !open },
            )
        }
    }
    if (e.prayer && open) {
        for ((state, zones) in PrayerZones.BY_STATE) {
            LookSublabel(state)
            LookRadioList(
                zones.map { RadioChoice(it.code, it.areas, it.code) }, e.prayerZone,
                { code -> x.edit(onEdit) { copy(prayerZone = code) } },
            )
        }
    }
}
