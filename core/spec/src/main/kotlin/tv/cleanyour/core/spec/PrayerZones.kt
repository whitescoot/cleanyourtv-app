package tv.cleanyour.core.spec

// The JAKIM e-Solat prayer zones (https://www.e-solat.gov.my): one code per area of Malaysia, the
// code the TV's home screen sends to e-Solat as `zone` (PrayerTimes.java, config.json prayer_zone).
// The list is typed in here, not fetched, so the picker works without the internet; if JAKIM adds,
// merges or renames a zone, change it here and ship an app update. A code that is not in the list
// is never written to the TV (LookExtrasKeys.keys).
data class PrayerZone(val code: String, val state: String, val areas: String)

object PrayerZones {
    // The zone a person who turns prayer times on starts from: Kuala Lumpur and Putrajaya.
    const val DEFAULT = "WLY01"

    val ALL: List<PrayerZone> = listOf(
        PrayerZone("JHR01", "Johor", "Pulau Aur dan Pulau Pemanggil"),
        PrayerZone("JHR02", "Johor", "Johor Bahru, Kota Tinggi, Mersing, Kulai"),
        PrayerZone("JHR03", "Johor", "Kluang, Pontian"),
        PrayerZone("JHR04", "Johor", "Batu Pahat, Muar, Segamat, Gemas Johor, Tangkak"),
        PrayerZone("KDH01", "Kedah", "Kota Setar, Kubang Pasu, Pokok Sena"),
        PrayerZone("KDH02", "Kedah", "Kuala Muda, Yan, Pendang"),
        PrayerZone("KDH03", "Kedah", "Padang Terap, Sik"),
        PrayerZone("KDH04", "Kedah", "Baling"),
        PrayerZone("KDH05", "Kedah", "Bandar Baharu, Kulim"),
        PrayerZone("KDH06", "Kedah", "Langkawi"),
        PrayerZone("KDH07", "Kedah", "Gunung Jerai"),
        PrayerZone("KTN01", "Kelantan", "Kota Bharu, Bachok, Pasir Puteh, Tumpat, Pasir Mas, Tanah Merah, Machang, Kuala Krai, Mukim Chiku"),
        PrayerZone("KTN03", "Kelantan", "Gua Musang (Galas dan Bertam), Jeli, Lojing"),
        PrayerZone("MLK01", "Melaka", "Seluruh Negeri Melaka"),
        PrayerZone("NGS01", "Negeri Sembilan", "Tampin, Jempol"),
        PrayerZone("NGS02", "Negeri Sembilan", "Jelebu, Kuala Pilah, Rembau"),
        PrayerZone("NGS03", "Negeri Sembilan", "Port Dickson, Seremban"),
        PrayerZone("PHG01", "Pahang", "Pulau Tioman"),
        PrayerZone("PHG02", "Pahang", "Kuantan, Pekan, Muadzam Shah"),
        PrayerZone("PHG03", "Pahang", "Jerantut, Temerloh, Maran, Bera, Chenor, Jengka"),
        PrayerZone("PHG04", "Pahang", "Bentong, Lipis, Raub"),
        PrayerZone("PHG05", "Pahang", "Genting Sempah, Janda Baik, Bukit Tinggi"),
        PrayerZone("PHG06", "Pahang", "Cameron Highlands, Genting Highlands, Bukit Fraser"),
        PrayerZone("PRK01", "Perak", "Tapah, Slim River, Tanjung Malim"),
        PrayerZone("PRK02", "Perak", "Ipoh, Batu Gajah, Kampar, Kuala Kangsar, Sungai Siput"),
        PrayerZone("PRK03", "Perak", "Lenggong, Pengkalan Hulu, Grik"),
        PrayerZone("PRK04", "Perak", "Temengor, Belum"),
        PrayerZone("PRK05", "Perak", "Teluk Intan, Bagan Datuk, Seri Iskandar, Beruas, Parit, Lumut, Sitiawan, Pulau Pangkor"),
        PrayerZone("PRK06", "Perak", "Selama, Taiping, Bagan Serai, Parit Buntar"),
        PrayerZone("PRK07", "Perak", "Bukit Larut"),
        PrayerZone("PLS01", "Perlis", "Kangar, Padang Besar, Arau"),
        PrayerZone("PNG01", "Pulau Pinang", "Seluruh Negeri Pulau Pinang"),
        PrayerZone("SBH01", "Sabah", "Sandakan, Bukit Garam, Semawang, Temanggong, Tambisan"),
        PrayerZone("SBH02", "Sabah", "Beluran, Telupid, Pinangah, Terusan, Kuamut"),
        PrayerZone("SBH03", "Sabah", "Lahad Datu, Silabukan, Kunak, Sahabat, Semporna, Tungku"),
        PrayerZone("SBH04", "Sabah", "Tawau, Balong, Merotai, Kalabakan"),
        PrayerZone("SBH05", "Sabah", "Kudat, Kota Marudu, Pitas, Pulau Banggi"),
        PrayerZone("SBH06", "Sabah", "Gunung Kinabalu"),
        PrayerZone("SBH07", "Sabah", "Kota Kinabalu, Ranau, Kota Belud, Tuaran, Penampang, Papar, Putatan"),
        PrayerZone("SBH08", "Sabah", "Pensiangan, Keningau, Tambunan, Nabawan"),
        PrayerZone("SBH09", "Sabah", "Beaufort, Kuala Penyu, Sipitang, Tenom, Long Pa Sia, Membakut, Weston"),
        PrayerZone("SWK01", "Sarawak", "Limbang, Lawas, Sundar, Trusan"),
        PrayerZone("SWK02", "Sarawak", "Miri, Niah, Bekenu, Sibuti, Marudi"),
        PrayerZone("SWK03", "Sarawak", "Pandan, Belaga, Suai, Tatau, Sebauh, Bintulu"),
        PrayerZone("SWK04", "Sarawak", "Sibu, Mukah, Dalat, Song, Igan, Oya, Balingian, Kanowit, Kapit"),
        PrayerZone("SWK05", "Sarawak", "Sarikei, Matu, Julau, Rajang, Daro, Bintangor, Belawai"),
        PrayerZone("SWK06", "Sarawak", "Lubok Antu, Sri Aman, Roban, Debak, Kabong, Lingga, Engkelili, Betong, Spaoh, Pusa, Saratok"),
        PrayerZone("SWK07", "Sarawak", "Serian, Simunjan, Samarahan, Sebuyau, Meludam"),
        PrayerZone("SWK08", "Sarawak", "Kuching, Bau, Lundu, Sematan"),
        PrayerZone("SWK09", "Sarawak", "Zon khas (Kampung Patarikan)"),
        PrayerZone("SGR01", "Selangor", "Gombak, Petaling, Sepang, Hulu Langat, Hulu Selangor, Rawang, Shah Alam"),
        PrayerZone("SGR02", "Selangor", "Kuala Selangor, Sabak Bernam"),
        PrayerZone("SGR03", "Selangor", "Klang, Kuala Langat"),
        PrayerZone("TRG01", "Terengganu", "Kuala Terengganu, Marang, Kuala Nerus"),
        PrayerZone("TRG02", "Terengganu", "Besut, Setiu"),
        PrayerZone("TRG03", "Terengganu", "Hulu Terengganu"),
        PrayerZone("TRG04", "Terengganu", "Dungun, Kemaman"),
        PrayerZone("WLY01", "Wilayah Persekutuan", "Kuala Lumpur, Putrajaya"),
        PrayerZone("WLY02", "Wilayah Persekutuan", "Labuan"),
    )

    // The states in e-Solat's order, each with its zones.
    val BY_STATE: List<Pair<String, List<PrayerZone>>> = ALL.groupBy { it.state }.toList()

    private val byCode: Map<String, PrayerZone> = ALL.associateBy { it.code }

    fun of(code: String?): PrayerZone? = code?.trim()?.uppercase()?.let { byCode[it] }

    fun isValid(code: String?): Boolean = of(code) != null
}
