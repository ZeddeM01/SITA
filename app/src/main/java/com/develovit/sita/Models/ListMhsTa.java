package com.develovit.sita.Models;

public class ListMhsTa {
    String namaMhs;
    String judulTa;
    String pembimbing;

    public ListMhsTa(){}

    public ListMhsTa(String namaMhs, String judulTa, String pembimbing) {
        this.namaMhs = namaMhs;
        this.judulTa = judulTa;
        this.pembimbing = pembimbing;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getJudulTa() {
        return judulTa;
    }

    public void setJudulTa(String judulTa) {
        this.judulTa = judulTa;
    }

    public String getPembimbing() {
        return pembimbing;
    }

    public void setPembimbing(String pembimbing) {
        this.pembimbing = pembimbing;
    }
}
