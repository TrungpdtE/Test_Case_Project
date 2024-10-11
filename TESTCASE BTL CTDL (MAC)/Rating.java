public class Rating {
    private int MaNguoiXem;
    private int MaPhim;
    private int SaoDanhGia;
    private long DauThoiGian;

    public Rating(int MaNguoiXem, int MaPhim, int SaoDanhGia, long DauThoiGian) {
        this.MaNguoiXem = MaNguoiXem;
        this.MaPhim = MaPhim;
        this.SaoDanhGia = SaoDanhGia;
        this.DauThoiGian = DauThoiGian;
    }
    public int getMaNguoiXem() {
        return MaNguoiXem;
    }
    public void setMaNguoiXem(int MaNguoiXem) {
        this.MaNguoiXem = MaNguoiXem;
    }
    public int getIDPhim() {
        return MaPhim;
    }
    public void setIDPhim(int MaPhim) {
        this.MaPhim = MaPhim;
    }
    public int getSaoDanhGia() {
        return SaoDanhGia;
    }
    public void setSaoDanhGia(int SaoDanhGia) {
        this.SaoDanhGia = SaoDanhGia;
    }
    public long getDauThoiGian() {
        return DauThoiGian;
    }
    public void setDauThoiGian(long DauThoiGian) {
        this.DauThoiGian = DauThoiGian;
    }
    @Override
    public String toString() {
        return String.format("Rating[%d, %d, %d, %d]", MaNguoiXem, MaPhim, SaoDanhGia, DauThoiGian);
    }


}
