package com.ptit.pakandroid.kentran97.newfirebasedatabase;

/**
 * Created by admin on 1/18/2018.
 */

public class SinhVien {
    public String HoTen, DiaChi;
    public int NamSinh;

    public SinhVien() {
        //mac dinh cua Firebase, khi nhan data
    }

    public SinhVien(String hoTen, String diaChi, int namSinh) {
        HoTen = hoTen;
        DiaChi = diaChi;
        NamSinh = namSinh;
    }
}
