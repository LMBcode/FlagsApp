package com.example.flagsapp.Model

import com.example.flagsapp.R

object QuestionsSource {
    const val CorrectAnswer = "correct_answers"
    const val Username = "username"

    const val mCorrectAnswer = "correct_answers"
    const val mUsername = "username"


    fun guessFlags(): List<Flags> {
        val questionsList: List<Flags> = listOf(
            Flags(
                R.drawable.ae,
                "UAE"

            ),
            Flags(
                R.drawable.ar,
                "ARGENTINA"
            ),
            Flags(
                R.drawable.be,
                "BELGIUM"
            ),
            Flags(
                R.drawable.br,
                "BRAZIL"

            ),
            Flags(
                R.drawable.sn,
                "SENEGAL"
            ),
            Flags(
                R.drawable.cl,
                "CHILE"
            ),
            Flags(
                R.drawable.gh,
                "GHANA"
            ),
            Flags(
                R.drawable.iq,
                "IRAQ"
            ),
            Flags(
                R.drawable.jo,
                "JORDAN"
            ),
            Flags(
                R.drawable.kw,
                "KUWAIT"
            ),
            Flags(
                R.drawable.mr,
                "MAURITANIA"
            ),
            Flags(
                R.drawable.sl,
                "SIERRA LEONE"
            ),
            Flags(
                R.drawable.za,
                "SOUTH AFRICA"
            ),
            Flags(
                R.drawable.sk,
                "SLOVAKIA"
            ),
            Flags(
                R.drawable.pa,
                "PANAMA"
            ),
            Flags(
                R.drawable.pr,
                "PUERTO RICO"
            ),
            Flags(
                R.drawable.fr,
                "FRANCE"
            ),
            Flags(
                R.drawable.es,
                "SPAIN"
            ),
            Flags(
                R.drawable.de,
                "GERMANY"
            ),
            Flags(
                R.drawable.nl,
                "NETHERLANDS"
            ),
            Flags(
                R.drawable.fi,
                "FINLAND"
            ),
            Flags(
                R.drawable.bf,
                "BURKINA FASO"
            ),
            Flags(
                R.drawable.vn,
                "VIETNAM"
            ),
            Flags(
                R.drawable.zm,
                "ZAMBIA"
            ),
            Flags(
                R.drawable.mz,
                "MOZAMBIQUE"
            ),
            Flags(
                R.drawable.bo,
                "BOLIVIA"
            ),
            Flags(
                R.drawable.al,
                "ALBANIA"
            ),
            Flags(
                R.drawable.ua,
                "UKRAINE"
            ),
            Flags(
                R.drawable.us,
                "UNITED STATES"
            ),
            Flags(
                R.drawable.dk,
                "DENMARK"
            ),
            Flags(
                R.drawable.co,
                "COLOMBIA"
            ),
            Flags(
                R.drawable.fj,
                "FIJI"
            ),
            Flags(
                R.drawable.ec,
                "ECUADOR"
            ),
            Flags(
                R.drawable.eng,
                "ENGLAND"
            ),
            Flags(
                R.drawable.la,
                "LAOS"
            ),
            Flags(
                R.drawable.lb,
                "LEBANON"
            ),
            Flags(
                R.drawable.lu,
                "LUXEMBOURG"
            ),
            Flags(
                R.drawable.ly,
                "LIBYA"
            ),
            Flags(
                R.drawable.pe,
                "PERU"
            ),
            Flags(
                R.drawable.et,
                "ETHIOPIA"
            ),
            Flags(
                R.drawable.ee,
                "ESTONIA"
            ),
            Flags(
                R.drawable.hr,
                "CROATIA"
            ),
            Flags(
                R.drawable.`in`,
                "INDIA"
            ),
            Flags(
                R.drawable.pk,
                "PAKISTAN"
            ),
            Flags(
                R.drawable.sm,
                "SAN MARINO"
            ),
            Flags(
                R.drawable.so,
                "SOMALIA"
            ),
            Flags(
                R.drawable.ht,
                "HAITI"
            ),
            Flags(
                R.drawable.jm,
                "JAMAICA"
            ),

        )
        return questionsList.asSequence().shuffled().take(10).toList()
    }

    fun guessFlagbyCountry() : List<FlagQuestions>{
        val questionList : List<FlagQuestions> =
            listOf(
                FlagQuestions(
                    "United Arab Emirates",
                    R.drawable.ae,
                    R.drawable.kw,
                    R.drawable.jo,
                    R.drawable.sd,
                    1
                ),
                FlagQuestions(
                    "Argentina",
                    R.drawable.ni,
                    R.drawable.ar,
                    R.drawable.hn,
                    R.drawable.mx,
                    2
                ),
                FlagQuestions(
                    "Lithuania",
                    R.drawable.lt,
                    R.drawable.lv,
                    R.drawable.ee,
                    R.drawable.no,
                    1
                ),
                FlagQuestions(
                    "North Macedonia",
                    R.drawable.cy,
                    R.drawable.md,
                    R.drawable.mk,
                    R.drawable.af,
                    3
                ),
                FlagQuestions(
                    "Uzbekistan",
                    R.drawable.pa,
                    R.drawable.az,
                    R.drawable.kg,
                    R.drawable.uz,
                    4
                ),
                FlagQuestions(
                    "Botswana",
                    R.drawable.mz,
                    R.drawable.ls,
                    R.drawable.bw,
                    R.drawable.sd,
                    3
                ),
                FlagQuestions(
                    "Russia",
                    R.drawable.ru,
                    R.drawable.pk,
                    R.drawable.at,
                    R.drawable.ge,
                    1
                ),
                FlagQuestions(
                    "Georgia",
                    R.drawable.tc,
                    R.drawable.eng,
                    R.drawable.cy,
                    R.drawable.ge,
                    4
                ),
                FlagQuestions(
                    "Senegal",
                    R.drawable.ml,
                    R.drawable.sn,
                    R.drawable.gn,
                    R.drawable.tg,
                    2
                ),
                FlagQuestions(
                    "Fiji",
                    R.drawable.fi,
                    R.drawable.to,
                    R.drawable.fj,
                    R.drawable.vc,
                    3
                ),
                FlagQuestions(
                    "Bahrain",
                    R.drawable.bh,
                    R.drawable.qa,
                    R.drawable.om,
                    R.drawable.bs,
                    1
                ),
                FlagQuestions(
                    "Ghana",
                    R.drawable.bo,
                    R.drawable.za,
                    R.drawable.gh,
                    R.drawable.bs,
                    3
                ),
                FlagQuestions(
                    "Colombia",
                    R.drawable.ve,
                    R.drawable.co,
                    R.drawable.bo,
                    R.drawable.ec,
                    2
                ),
                FlagQuestions(
                    "Netherlands",
                    R.drawable.cr,
                    R.drawable.lu,
                    R.drawable.fr,
                    R.drawable.nl,
                    4
                ),
                FlagQuestions(
                    "France",
                    R.drawable.sl,
                    R.drawable.es,
                    R.drawable.fr,
                    R.drawable.ge,
                    3
                ),
                FlagQuestions(
                    "Spain",
                    R.drawable.ar,
                    R.drawable.cg,
                    R.drawable.mk,
                    R.drawable.es,
                    4
                ),
                FlagQuestions(
                    "Saudi Arabia",
                    R.drawable.sa,
                    R.drawable.qa,
                    R.drawable.ae,
                    R.drawable.kw,
                    1
                ),
                FlagQuestions(
                    "Germany",
                    R.drawable.be,
                    R.drawable.de,
                    R.drawable.mx,
                    R.drawable.nl,
                    2
                ),
                FlagQuestions(
                    "Egypt",
                    R.drawable.sy,
                    R.drawable.iq,
                    R.drawable.eg,
                    R.drawable.lb,
                    3
                ),
                FlagQuestions(
                    "Lebanon",
                    R.drawable.az,
                    R.drawable.lb,
                    R.drawable.ae,
                    R.drawable.id,
                    2
                ),
                FlagQuestions(
                    "Ivory Coast",
                    R.drawable.ie,
                    R.drawable.ci,
                    R.drawable.sl,
                    R.drawable.cm,
                    2
                ),
                FlagQuestions(
                    "Nigeria",
                    R.drawable.ng,
                    R.drawable.tn,
                    R.drawable.al,
                    R.drawable.kw,
                    1
                ),
                FlagQuestions(
                    "Tunisia",
                    R.drawable.az,
                    R.drawable.al,
                    R.drawable.ke,
                    R.drawable.tn,
                    4
                ),
                FlagQuestions(
                    "Libya",
                    R.drawable.iq,
                    R.drawable.sc,
                    R.drawable.ly,
                    R.drawable.kw,
                    3
                ),
                FlagQuestions(
                    "Guatemala",
                    R.drawable.gt,
                    R.drawable.th,
                    R.drawable.hn,
                    R.drawable.hu,
                    1
                ),
                FlagQuestions(
                    "Thailand",
                    R.drawable.ph,
                    R.drawable.sg,
                    R.drawable.th,
                    R.drawable.np,
                    3
                ),
                FlagQuestions(
                    "Singapore",
                    R.drawable.id,
                    R.drawable.pl,
                    R.drawable.mc,
                    R.drawable.sg,
                    4
                ),
                FlagQuestions(
                    "Hong Kong",
                    R.drawable.ma,
                    R.drawable.mu,
                    R.drawable.hk,
                    R.drawable.cn,
                    3
                ),
                FlagQuestions(
                    "Algeria",
                    R.drawable.dz,
                    R.drawable.dj,
                    R.drawable.ma,
                    R.drawable.by,
                    1
                ),
                FlagQuestions(
                    "Kazakhstan",
                    R.drawable.sl,
                    R.drawable.uz,
                    R.drawable.az,
                    R.drawable.kz,
                    4
                ),
                FlagQuestions(
                    "Malta",
                    R.drawable.pa,
                    R.drawable.va,
                    R.drawable.mt,
                    R.drawable.rw,
                    3
                ),
                FlagQuestions(
                    "Slovenia",
                    R.drawable.rs,
                    R.drawable.si,
                    R.drawable.sk,
                    R.drawable.ru,
                    2
                ),
                FlagQuestions(
                    "Tanzania",
                    R.drawable.ke,
                    R.drawable.ls,
                    R.drawable.mz,
                    R.drawable.tz,
                    4
                ),
                FlagQuestions(
                    "Faroe Islands",
                    R.drawable.fo,
                    R.drawable.co,
                    R.drawable.mz,
                    R.drawable.tz,
                    1
                ),
                FlagQuestions(
                    "India",
                    R.drawable.cl,
                    R.drawable.`in`,
                    R.drawable.sl,
                    R.drawable.sr,
                    2
                ),
                FlagQuestions(
                    "Pakistan",
                    R.drawable.uz,
                    R.drawable.`in`,
                    R.drawable.pk,
                    R.drawable.az,
                    3
                ),

            )
        return questionList.asSequence().shuffled().take(15).toList()
    }
}
