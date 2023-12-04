package njit.rocky.airlinereviews.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import njit.rocky.airlinereviews.R

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_notifications, container, false)

        val notificationListView = rootView.findViewById<ListView>(R.id.notificationListView)
        val notificationTexts = arrayOf(
            "SU, ULE, AB Aviation, China",
            "JU, RZW, Adria Airways, France",
            "HY, DKL, Aegean Airlines, China",
            "NH, WJC, Aer Lingus, Norway",
            "WN, JVX, Aero VIP, United Arab Emirates",
            "KB, BPD, Aeroflot Russian Airlines, Norway",
            "PM, EPN, AeroItalia, Japan",
            "LW, DOS, Aerolineas Argentinas, Japan",
            "DZ, VRQ, Aeromar, United States",
            "NX, YAL, Aeromexico, Mexico",
            "RS, YXC, Africa World Airlines, Finland",
            "HW, MMF, Aigle Azur, Saudi Arabia",
            "XR, HZA, Air Algerie, Italy",
            "QX, PBA, Air Antilles, Japan",
            "CL, MVY, Air Arabia, Japan",
            "OU, TOI, Air Astana, Belgium",
            "RZ, LYT, Air Austral, Brazil",
            "RD, SIT, Air Berlin, Turkey",
            "HZ, XDG, Air Botswana, United States",
            "SX, BEF, Air Burkina, South Africa",
            "SS, KEL, Air Busan, Egypt",
            "DH, FIF, Air Cairo, Japan",
            "ZF, FQG, Air Canada, Austria",
            "RP, BRQ, Air Canada rouge, Malaysia",
            "EK, VSI, Air Caraibes, United Kingdom",
            "SQ, KUR, Air China, Saudi Arabia",
            "BF, BAT, Air Corsica, China",
            "UC, GVG, Air Costa, Portugal",
            "BX, TLA, Air Cote d'Ivoire, Turkey",
            "JE, FYV, Air Djibouti, United Kingdom",
            "TC, YPA, Air Dolomiti, Turkey",
            "KQ, YDI, Air Europa, United States",
            "UI, IVJ, Air France, Spain",
            "WU, UGU, Air Greenland, Switzerland",
            "PJ, OKY, Air Iceland Connect, China",
            "MN, NVS, Air India, Indonesia",
            "FD, MNF, Air India Express, United States",
            "LC, PTJ, Air Italy, China",
            "XM, HOY, Air Juan, United States",
            "SK, YHL, Air KBZ, Russia",
            "WV, UMJ, Air Koryo, Denmark",
            "PQ, SEU, Air Macau, South Africa",
            "XH, AND, Air Madagascar, South Korea",
            "GX, VZO, Air Malta, Russia",
            "XJ, OFB, Air Mauritius, Italy",
            "QP, DYA, Air Moldova, Japan",
            "NS, MMN, Air Namibia, Malaysia",
            "IW, SXL, Air New Zealand, Italy",
            "AD, CHT, Air Niugini, South Korea",
            "MK, SWG, Air North Yukon's Airline, United Kingdom",
            "KN, EAX, Air Nostrum, Sweden",
            "BG, GML, Air Panama, Russia",
            "ED, VVK, Air Pegasus, Switzerland",
            "AV, LDU, Air Rarotonga, United States",
            "DK, VXF, Air Serbia, India",
            "YS, EVW, Air Seychelles, Belgium",
            "TN, JIU, Air Tahiti Nui, Saudi Arabia",
            "TV, GXG, Air Tanzania, China",
            "PV, GSA, Air Transat, Czech Republic",
            "IR, XWE, Air Zimbabwe, Greece",
            "GR, SXM, AirAsia, Switzerland",
            "ER, AEI, AirAsia India, Ukraine",
            "UW, DPA, AirAsia Philippines, Australia",
            "HC, XPQ, AirAsia X, United Arab Emirates",
            "PP, ORN, AirAsia Zest, Switzerland",
            "FB, QYH, airBaltic, United Kingdom",
            "OS, BCL, Aircalin, Germany",
            "KE, MBV, Airlink, Ireland",
            "XZ, FFS, Airnorth, United States",
            "VZ, UTN, AirSWIFT, India",
            "MB, DUC, Akasa Air, Japan",
            "IU, YAQ, Alaska Airlines, Turkey",
            "ZQ, UIT, Alitalia, United States",
            "PY, MLV, Allegiant Air, Italy",
            "HE, AAO, Alliance Air, United States",
            "EG, WEA, Alliance Airlines, Canada",
            "MT, GUO, Amaszonas, Singapore",
            "ZC, TQZ, American Airlines, Argentina",
            "RB, AOR, American Eagle, United States",
            "CI, HNE, ANA All Nippon Airways, France",
            "AP, NDE, AnadoluJet, Japan",
            "ZN, HVI, Andes Líneas Aéreas, United Arab Emirates",
            "ZS, JEI, Ariana Afghan Airlines, Switzerland",
            "ZV, QJS, Arik Air, United Kingdom",
            "PO, ASN, Arkefly, Germany",
            "DU, UMG, Armenia Air Company, Saudi Arabia",
            "WL, AYX, Asiana Airlines, Malaysia",
            "LZ, OXR, ASKY Airlines, Egypt",
            "BD, ZWK, ATA Airlines, Germany",
            "PC, OJU, Atlantic Airways, South Africa",
            "QK, RIO, Auric Air, United States",
            "JT, HOX, Aurigny Air, Czech Republic",
            "LG, BHD, Austrian Airlines, Finland",
            "NM, MOK, Avelo Airlines, Singapore",
            "XX, ZWM, Avianca, South Africa",
            "CP, BNN, Avior Airlines, Germany",
            "CG, ZTN, Azerbaijan Airlines, Italy",
            "BI, CCF, Azur Air Germany, Israel",
            "HG, FRV, BA CityFlyer, United States",
            "RY, XOJ, Badr Airlines, Portugal",
            "UX, KPM, Bahamasair, Japan",
            "JP, NYC, Bamboo Airways, United States",
            "JF, BXF, Bangkok Airways, Japan",
            "EV, YIN, Bassaka Air, Malaysia",
            "VU, ATE, Batik Air, Russia",
            "GZ, FSR, Beijing Capital Airlines, India",
            "BR, RPU, Belavia, Norway",
            "MM, MEF, Bhutan Airlines, Brazil",
            "DY, MWT, Binter Canarias, Egypt",
            "ZE, VDX, Blue Air, Argentina",
            "CF, FHK, Blue Islands, India",
            "VL, VPM, Blue Panorama Airlines, Japan",
            "WY, NMA, Blue1, Indonesia",
            "QS, NUQ, Bluebird Airways, Canada",
            "OH, YRC, bmi Regional, Canada",
            "PS, PTL, BoraJet, India",
            "AE, TKL, Boutique Air, United States",
            "BL, TQW, Breeze Airways, France",
            "PW, LHD, British Airways, United States",
            "XI, MRH, Brussels Airlines, China",
            "AL, RKV, Buddha Air, China",
            "AH, WJG, Bulgaria Air, Canada",
            "BT, BMH, Buta Airways, France",
            "LQ, KBL, Camair-Co, Qatar",
            "EH, MOG, Cambodia Airways, United States",
            "CN, DEN, Cambodia Bayon Airlines, Turkey",
            "EL, EGX, Canadian North, Japan",
            "FW, FDW, Canaryfly, Norway",
            "TT, CQV, Cape Air, Indonesia",
            "CE, NED, Caribbean Airlines, Brazil",
            "JY, NIG, Cathay Dragon, Indonesia",
            "OJ, SQQ, Cathay Pacific Airways, Turkey",
            "CD, FED, Cayman Airways, Japan",
            "UP, WSC, Cebu Pacific, Mexico",
            "JW, CHY, CemAir, Turkey",
            "YI, WNO, Central Mountain Air, China",
            "YU, PJM, China Airlines, Singapore",
            "KP, TIL, China Eastern Airlines, India",
            "YY, ATF, China Southern Airlines, Qatar",
            "IZ, EFU, China United Airlines, Brazil",
            "KL, MUS, Citilink, United Arab Emirates",
            "YT, SUE, CityJet, Austria",
            "PX, RZQ, Coastal Aviation, Russia",
            "AS, NSU, Cobalt, New Zealand",
            "BV, LSB, Comair, Malaysia",
            "MI, RUY, Condor Airlines, Canada",
            "LY, TGN, Copa Airlines, India",
            "TJ, TDW, Corendon Airlines, United Kingdom",
            "LT, TEU, Corsair, South Africa",
            "WI, AAH, Croatia Airlines, Greece",
            "IY, BEC, CSA Czech Airlines, Japan",
            "DL, LLN, Cubana Airlines, United States",
            "QL, KCC, Cyprus Airways, Ireland",
            "MO, KMS, Delta Air Lines, India",
            "GG, YJA, Dimonim Air, Spain",
            "OG, RZE, Dragonair, Finland",
            "GQ, HZO, Druk Air, Russia",
            "RC, HEA, Dynamic International Airways, Russia",
            "OW, VVD, Eastern Airlines, Saudi Arabia",
            "WR, VXI, Eastern Airways, South Korea",
            "SZ, FYP, Easyfly, United Kingdom",
            "FT, IKH, easyJet, Japan",
            "CB, KUQ, Edelweiss Air, South Korea",
            "SP, HXI, Egyptair, United States",
            "MQ, LYN, El Al Israel Airlines, Turkey",
            "PE, GQQ, Ellinair, Switzerland",
            "BJ, HLA, Emirates, Belgium",
            "NB, RNQ, Ernest Airlines, Canada",
            "VT, QBE, Estonian Air, Malaysia",
            "YB, KUP, Eswatini Air, United States",
            "JZ, SBR, Ethiopian Airlines, South Korea",
            "AM, OXQ, Etihad Airways, Malaysia",
            "QN, VEK, euroAtlantic Airways, Brazil",
            "XQ, PWL, Eurowings, Egypt",
            "BE, SWI, EVA Air, United States",
            "XW, UUK, Evelop Airlines, Finland",
            "TR, CNC, EWA Air, Portugal",
            "SM, DQM, Ravn Alaska, France",
            "BW, MNO, fastjet, Mexico",
            "EN, SMS, Felix Airways, Australia",
            "UG, NYD, Fiji Airways, Japan",
            "RO, GAS, Finnair, Egypt",
            "WW, VKF, Firefly, United Kingdom",
            "WC, MPO, Flair Airlines, Egypt",
            "PG, YHV, Fly540.com, Ukraine",
            "DN, SGO, flyadeal, Australia",
            "CM, CQG, FlyArystan, Singapore",
            "UD, XCB, flybe, Brazil",
            "HT, IOC, flydubai, Italy",
            "GN, HWM, Flynas, India",
            "ZL, DTJ, FLYONE, Greece",
            "LE, YMW, FlySafair, Japan",
            "HS, WJS, FMI Air, United Kingdom",
            "UF, KZA, French Bee, China",
            "LX, UKW, Frontier Airlines, Greece",
            "DF, IQZ, Garuda Indonesia, Germany",
            "KU, KAG, Georgian Airways, Finland",
            "BS, BCD, Germania Airline, Russia",
            "UA, HKK, Germanwings, Brazil",
            "IF, GEW, Go First, Qatar",
            "OL, BSI, GoAir, Czech Republic",
            "JB, AWS, Golden Myanmar Airlines, Switzerland",
            "NI, EWV, Grand Cru Airlines, United States",
            "HX, EPM, Greater Bay Airlines, China",
            "VW, UUN, Gulf Air, Qatar",
            "OO, UOW, Hainan Airlines, Switzerland",
            "GJ, VHL, Hawaiian Airlines, Japan",
            "II, VPH, Hi Fly, United Kingdom",
            "XL, MMG, Himalaya Airlines, China",
            "UT, SHF, HiSky, Poland",
            "RN, TZK, Hong Kong Airlines, United States",
            "BK, BGD, HOP!, Israel",
            "BZ, DEG, Horizon Air, Indonesia",
            "KI, HPB, Hunnu Air, Denmark",
            "KK, DKJ, Iberia, Belgium",
            "UJ, OIC, Iberia Express, United Kingdom",
            "FP, FIT, Iberojet, China",
            "OF, ZXF, Icelandair, Switzerland",
            "WH, LUA, Insel Air, Italy",
            "HR, KMO, Intercaribbean Airways, Australia",
            "IG, ZCN, Interjet, Brazil",
            "WP, RWB, Iran Air, Netherlands",
            "MZ, WGL, Iraqi Airways, Malaysia",
            "DW, XSG, Israir Airlines, Denmark",
            "TX, VCZ, ITA Airways, Australia",
            "YQ, OKW, Japan Airlines, France",
            "ME, JIL, Jazeera Airways, China",
            "KF, TZM, Jazz, United States",
            "ZI, WOO, JC International Airlines, Singapore",
            "OR, ETG, Jeju Air, Poland",
            "KJ, LLM, Jet Airways, Thailand",
            "IA, EAG, Jet2.com, Germany",
            "QQ, PHJ, Jetairfly, France",
            "TH, EYH, Jetblue Airways, South Korea",
            "ZJ, EGZ, JetSmart, Switzerland",
            "VN, FOD, Jetstar Airways, Indonesia",
            "ZM, KHX, Jetstar Asia, China",
            "XV, OIJ, Jetstar Japan, India",
            "SD, XFK, Jetstar Pacific, United Kingdom",
            "NE, VBU, JetsuiteX, Saudi Arabia",
            "OX, WZO, Jin Air, Mexico",
            "NR, LGW, Joon, United Arab Emirates",
            "DV, VYL, Jordan Aviation, South Africa",
            "FQ, GOO, Kam Air, Egypt",
            "JN, SUM, Kan Air, Indonesia",
            "IQ, OUD, KD Air, United Kingdom",
            "VQ, NAM, Kenya Airways, South Korea",
            "TB, RVM, KLM Royal Dutch Airlines, France",
            "RM, QAW, Korean Air, Russia",
            "DG, GHE, Kulula, Russia",
            "WD, TPN, Kuwait Airways, China",
            "TZ, JQV, La Compagnie, Belgium",
            "AZ, JXF, LAN Airlines, Italy",
            "UO, VOA, LAN Colombia, India",
            "EC, OPY, LAN Peru, Australia",
            "YF, KWR, Lao Airlines, Norway",
            "BC, AAE, LATAM Airlines, South Africa",
            "LA, YBT, Laudamotion, China",
            "AT, PNV, LC Perú, United Kingdom",
            "QF, FUJ, Level, Turkey",
            "IM, KEN, LIAT, Canada",
            "QE, QQT, Libyan Airlines, Qatar",
            "HL, UMR, Lion Air, United Arab Emirates",
            "KG, ZEV, Loganair, Russia",
            "AJ, EQB, LOT Polish Airlines, Brazil",
            "DI, OFX, Lubeck Air, United Arab Emirates",
            "AC, FMX, Lucky Air, Argentina",
            "EI, EVB, Lufthansa, Qatar",
            "HV, ULG, Luxair, Switzerland",
            "UM, WQV, Lynx Air, Thailand",
            "JQ, JPX, Mack Air, Belgium",
            "KR, TEJ, Madagasikara Airways, China",
            "QZ, QDE, Mahan Air, Germany",
            "DR, JUR, Malawian Airlines, Mexico",
            "VG, XLW, Malaysia Airlines, Italy",
            "RF, FDK, Maldivian, United Kingdom",
            "UU, IWQ, Malindo Air, Spain",
            "NW, ARC, Mandarin Airlines, Germany",
            "IC, NMV, Mann Yadanarpon Airlines, Japan",
            "XK, MAO, Manta Air, Japan",
            "TP, HZG, Mauritania Airlines, Canada",
            "BB, LYX, Maya Island Air, Australia",
            "AR, PIB, MAYAir, Canada",
            "VO, YXF, MEGA Maldives Airlines, Netherlands",
            "BH, SSC, Meridiana, India",
            "AU, AUE, Mihin Lanka, China",
            "CJ, HBX, Mokulele Airlines, Indonesia",
            "AN, COA, Monarch Airlines, China",
            "GH, NTN, Montenegro Airlines, India",
            "IO, IMM, Motor Sich Airlines, Australia",
            "SY, CRF, Myanmar Airways, Germany",
            "SV, DBV, Myanmar National Airlines, Turkey",
            "PB, MZG, NAM Air, Canada",
            "IL, LXX, Nature Air, Russia",
            "UZ, ING, Nauru Airlines, Austria",
            "YX, VCE, Nepal Airlines, Germany",
            "IN, XMT, NIKI, Canada",
            "RK, UFG, Nile Air, Turkey",
            "RE, DUU, Nok Air, Indonesia",
            "YZ, PEO, NokScoot, South Africa",
            "HA, WSV, Nordavia, Brazil",
            "MY, IZO, Nordic Regional Airlines, India",
            "DB, LFN, Nordica, Finland",
            "GA, PCX, NordStar, China",
            "QH, UGY, Nordwind Airlines, Netherlands",
            "KM, NGK, Norse Atlantic Airways, United Kingdom",
            "FA, WFV, Norwegian, United States",
            "ZR, ABO, Nouvelair, South Korea",
            "HP, APR, Novoair, Belgium",
            "ZO, AHT, Olympic Air, United States",
            "YG, WYK, Oman Air, Malaysia",
            "QR, ROR, Omni Air International, Austria",
            "VV, WVO, Onur Air, Russia",
            "CR, XEM, Openskies, Spain",
            "LM, APJ, Pacific Airlines, Germany",
            "KO, SVF, PAL Express, Egypt",
            "EW, UZB, Pan Pacific Airlines, India",
            "TI, YOZ, Passion Air, United Kingdom",
            "KH, SDV, PAWA Dominicana, Argentina",
            "GK, VVH, Peach Aviation, United States",
            "FV, ITU, Pegasus Airlines, Germany",
            "MW, USY, PenAir, United States",
            "VB, PKQ, Peruvian Airlines, Brazil",
            "EX, WGP, Petroleum Air Services, United Arab Emirates",
            "MF, SFY, Philippine Airlines, Germany",
            "WQ, NTP, PLAY, Australia",
            "JV, WWJ, Pobeda Airlines, Singapore",
            "PR, VSH, Porter Airlines, United States",
            "ZH, OSR, Primera Air, Egypt",
            "IJ, BKO, Privilege Style, Turkey",
            "HF, XTR, Qantas Airways, India",
            "FN, RVJ, QantasLink, Australia",
            "YD, HMY, Qatar Airways, Brazil",
            "XA, NSS, Qazaq Air, Sweden",
            "KS, KQI, Red Wings Airlines, Singapore",
            "BP, YKY, Regent Airways, India",
            "HN, KPF, Regional Express, Germany",
            "VD, CYU, Rex Airlines, Canada",
            "TF, JKA, Rhein-Neckar Air, Japan",
            "IH, SSP, Rossiya Airlines, China",
            "SE, YTF, Royal Air Maroc, Turkey",
            "VE, ZAP, Royal Brunei Airlines, United States",
            "GC, YBX, Royal Jordanian Airlines, China",
            "DT, DUR, Rwandair, United Kingdom",
            "XG, JGC, Ryanair, Canada",
            "XD, XON, S7 Siberia Airlines, Switzerland",
            "DD, RAZ, SA Express, Denmark",
            "CQ, OMH, Safarilink, Denmark",
            "WX, RJD, Safi Airways, Australia",
            "PI, DOX, Salam Air, Finland",
            "OB, CGH, Sansa Airlines, Indonesia",
            "OI, JQE, SATA Air Azores, Malaysia",
            "VM, QLM, SATENA, Indonesia",
            "XS, HHR, Saudi Arabian Airlines, Greece",
            "NN, MNP, SCAT Airlines, India",
            "MP, KGY, Scoot, United States",
            "CC, INH, Seaborne Airlines, United States",
            "UE, PRP, SereneAir, Malaysia",
            "LO, QZF, Shaheen Air, Russia",
            "ZK, WGO, Shandong Airlines, Norway",
            "LU, ZNK, Shanghai Airlines, Ireland",
            "GU, KJS, Shenzhen Airlines, Brazil",
            "RA, QVA, Sichuan Airlines, South Africa",
            "VR, HCC, SilkAir, Sweden",
            "ZB, DMI, Silver Airways, United Kingdom",
            "BQ, DPV, Singapore Airlines, United States",
            "TY, UDZ, Sky Airline, Turkey",
            "SG, KRW, Sky Express Airlines, Hungary",
            "JI, FAT, Skybus, Brazil",
            "ZU, DFI, Skymark Airlines, South Africa",
            "KC, AYE, Skytrans Airlines, Mexico",
            "GV, BFP, SkyUp Airlines, Australia",
            "MU, DOP, SkyWest Airlines, United States",
            "LS, VXB, SkyWork Airlines, India",
            "WJ, LCW, Smartavia, Romania",
            "EP, GHH, SmartLynx Airlines, Ireland",
            "TA, EBK, SmartWings, Italy",
            "MR, NFD, Solomon Airlines, Turkey",
            "WF, ACY, Somon Air, New Zealand",
            "EO, PRN, South African Airways, Finland",
            "AF, XPH, Southwest Airlines, Germany",
            "CU, MZD, SpiceJet, Belgium",
            "RI, TRP, Spirit Airlines, India",
            "ID, ZQS, SriLankan Airlines, Germany",
            "GW, QTX, Sriwijaya Air, Saudi Arabia",
            "BM, AZI, StarFlyer, Mexico",
            "ZA, JMN, Sun Country Airlines, Russia",
            "DX, RZF, Sun-Air, South Korea",
            "EE, QQX, Sunwing Airlines, China",
            "TE, AZZ, Suparna Airlines, India",
            "ZW, MDI, Super Air Jet, Finland",
            "QI, JHF, Surinam Airways, France",
            "PZ, XKM, SVG Air, Australia",
            "LJ, ROA, Swoop, France",
            "TD, EXV, T'Way Air, France",
            "KY, HZN, TAAG Angola Airlines, Qatar",
            "FC, BKB, TAG Airlines, Austria",
            "QU, JKK, Tailwind Airlines, Thailand",
            "IP, BHE, TAM Airlines, Brazil",
            "RV, GAL, TAME, China",
            "DE, YPY, Tame Línea Aérea Del Ecuador, United States",
            "QG, YYB, TAP Portugal, China",
            "AQ, HOF, TAR Aerolineas, China",
            "EB, PLR, Thai AirAsia, China",
            "JJ, HPN, Thai Airways, France",
            "DS, NIO, Thai Lion Air, Malaysia",
            "US, VHA, Thai Smile Airways, Germany",
            "SF, UEG, Thomas Cook Airlines, Japan",
            "ZZ, UOJ, Thomas Cook Airlines Scandinavia, Sweden",
            "XE, NZJ, Thomson Airways, China",
            "WS, XRW, Tianjin Airlines, United States",
            "BN, KLA, Tibet Airlines, Russia",
            "JH, IVZ, Tigerair, Japan",
            "VP, WGE, Tigerair Australia, India",
            "XC, RNJ, Tigerair Taiwan, Egypt",
            "HJ, XIX, Titan Airways, India",
            "LL, LLS, Transaero Airlines, Malaysia",
            "AI, XDU, Transavia, Brazil",
            "IK, BDN, TransNusa, Russia",
            "NY, TYT, Trigana Air, Spain",
            "UB, POJ, Tropic Air Belize, South Korea",
            "LB, GQO, TUI Airways, Germany",
            "HD, GKU, TUIfly, Qatar",
            "TQ, BZQ, TUIfly Nordic, Brazil",
            "FY, QWD, Tunisair, Austria",
            "DA, PIM, Turkish Airlines, United States",
            "AW, HMD, Turkmenistan Airlines, France",
            "FL, LWA, TUS Airways, Spain",
            "LN, UAP, Uganda Airlines, Argentina",
            "FR, GPX, Ultra Air, Australia",
            "ZX, IGE, United Airlines, Denmark",
            "QB, OYX, UP by El Al, China",
            "NF, FTA, Ural Airlines, Singapore",
            "SI, MOZ, US Airways, Australia",
            "OY, KRF, US-Bangla Airlines, United Kingdom",
            "FS, HPR, Utair Aviation, Qatar",
            "SC, TVG, Uzbekistan Airways, Japan",
            "RX, QAQ, V Air, Ireland",
            "NO, CXX, Vanilla Air, Russia",
            "JG, KZS, ViaAir, Sweden",
            "GL, QYO, Vietnam Airlines, Indonesia",
            "WT, GKC, Virgin America, United Arab Emirates",
            "QT, NWN, Virgin Australia, New Zealand",
            "VI, PRK, Vistara, Russia",
            "HQ, YBY, Viva Air, Norway",
            "ND, EZU, VivaAerobús, Australia",
            "KA, AEE, VivaColombia, Greece",
            "AY, VXU, VLM Airlines, Canada",
            "XY, PXP, Volaris, United States",
            "QY, KXX, Volotea, United Kingdom",
            "FJ, IVM, Voyage Air, United Kingdom",
            "GI, GTR, Vueling Airlines, Austria",
            "CX, OSW, Wamos Air, Indonesia",
            "TW, QAT, Wideroe, Qatar",
            "YM, JPD, Winair, Poland",
            "PT, SAU, Wingo, Norway",
            "ZD, MBI, Wings Air, Mexico",
            "GB, TVN, Wizz Air, Sweden",
            "YA, HSE, World2Fly, South Korea",
            "DC, POC, WOW air, India",
            "VJ, IKC, Xiamen Airlines, Russia",
            "KD, MNM, XL Airways France, United Kingdom",
            "BY, IOL, Yakutia Airlines, United States",
            "DO, PDD, Yangon Airways, Greece",
            "KX, FGT, Yeti Airlines, United States",
            "BO, XJX, Zambia Airways, Switzerland",
            "SA, NNP, ZIPAIR, United States"
        )

        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, notificationTexts)
        notificationListView.adapter = adapter

        return rootView
    }
}