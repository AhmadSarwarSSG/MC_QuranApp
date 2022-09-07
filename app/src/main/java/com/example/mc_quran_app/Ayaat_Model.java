package com.example.mc_quran_app;

public class Ayaat_Model {
    private int AyaID;
    private int SuraID;
    private int AyaNo;
    private String ArabicText;
    private String Fateh_Muhammad_Jalandhri;
    private String Mehmood_ul_Hassan;
    private String Dr_Mohsin_Khan;
    private String Mufti_Taqi_Usmani;
    private int RakuID;
    private int PRakuID;
    private int ParaID;

    public Ayaat_Model(int ayaID, int suraID, int ayaNo, String arabicText, String fateh_Muhammad_Jalandhri, String mehmood_ul_Hassan, String dr_Mohsin_Khan, String mufti_Taqi_Usmani, int rakuID, int PRakuID, int paraID) {
        AyaID = ayaID;
        SuraID = suraID;
        AyaNo = ayaNo;
        ArabicText = arabicText;
        Fateh_Muhammad_Jalandhri = fateh_Muhammad_Jalandhri;
        Mehmood_ul_Hassan = mehmood_ul_Hassan;
        Dr_Mohsin_Khan = dr_Mohsin_Khan;
        Mufti_Taqi_Usmani = mufti_Taqi_Usmani;
        RakuID = rakuID;
        this.PRakuID = PRakuID;
        ParaID = paraID;
    }

    public int getAyaID() {
        return AyaID;
    }

    public void setAyaID(int ayaID) {
        AyaID = ayaID;
    }

    public int getSuraID() {
        return SuraID;
    }

    public void setSuraID(int suraID) {
        SuraID = suraID;
    }

    public int getAyaNo() {
        return AyaNo;
    }

    public void setAyaNo(int ayaNo) {
        AyaNo = ayaNo;
    }

    public String getArabicText() {
        return ArabicText;
    }

    public void setArabicText(String arabicText) {
        ArabicText = arabicText;
    }

    public String getFateh_Muhammad_Jalandhri() {
        return Fateh_Muhammad_Jalandhri;
    }

    public void setFateh_Muhammad_Jalandhri(String fateh_Muhammad_Jalandhri) {
        Fateh_Muhammad_Jalandhri = fateh_Muhammad_Jalandhri;
    }

    public String getMehmood_ul_Hassan() {
        return Mehmood_ul_Hassan;
    }

    public void setMehmood_ul_Hassan(String mehmood_ul_Hassan) {
        Mehmood_ul_Hassan = mehmood_ul_Hassan;
    }

    public String getDr_Mohsin_Khan() {
        return Dr_Mohsin_Khan;
    }

    public void setDr_Mohsin_Khan(String dr_Mohsin_Khan) {
        Dr_Mohsin_Khan = dr_Mohsin_Khan;
    }

    public String getMufti_Taqi_Usmani() {
        return Mufti_Taqi_Usmani;
    }

    public void setMufti_Taqi_Usmani(String mufti_Taqi_Usmani) {
        Mufti_Taqi_Usmani = mufti_Taqi_Usmani;
    }

    public int getRakuID() {
        return RakuID;
    }

    public void setRakuID(int rakuID) {
        RakuID = rakuID;
    }

    public int getPRakuID() {
        return PRakuID;
    }

    public void setPRakuID(int PRakuID) {
        this.PRakuID = PRakuID;
    }

    public int getParaID() {
        return ParaID;
    }

    public void setParaID(int paraID) {
        ParaID = paraID;
    }
}
