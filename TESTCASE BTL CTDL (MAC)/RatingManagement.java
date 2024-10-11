import java.util.*;
import java.io.*;

public class RatingManagement {
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    public RatingManagement(String moviePath, String ratingPath, String userPath) {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<User> loadUsers(String userPath) {
        ArrayList<User> luuNguoiDung=new ArrayList<>();
        try{ 
            File mofile=new File(userPath);
            Scanner docfile=new Scanner(mofile);

            if(docfile.hasNextLine()){
                docfile.nextLine();
            }

            while(docfile.hasNextLine()){
                String dong=docfile.nextLine();
                String[] TachThongTin=dong.split(","); 
                int Manguoixem=Integer.parseInt(TachThongTin[0]);
                String GioiTinh=TachThongTin[1];
                int Tuoi=Integer.parseInt(TachThongTin[2]);
                String NgheNghiep=TachThongTin[3];
                String zipCode=TachThongTin[4];
                luuNguoiDung.add(new User(Manguoixem, GioiTinh, Tuoi, NgheNghiep, zipCode));
            }

            docfile.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return luuNguoiDung;
    }

    private ArrayList<Movie> loadMovies(String moviePath) {
        ArrayList<Movie> luuPhim=new ArrayList<>();

        try{
            File mofile=new File(moviePath);
            Scanner docfile=new Scanner(mofile);

            if(docfile.hasNextLine()){
                docfile.nextLine();
            }

            while(docfile.hasNextLine()){
                String dong=docfile.nextLine();
                String[] TachThongTin=dong.split(",");
                int MaPhim=Integer.parseInt(TachThongTin[0]);
                String TenPhim=TachThongTin[1];
                ArrayList<String> Theloai=new ArrayList<>();
                String[] Tachtheloai=TachThongTin[2].split("-");
                for (String theloai:Tachtheloai){
                    Theloai.add(theloai);
                }
                luuPhim.add(new Movie(MaPhim, TenPhim, Theloai));
            }

            docfile.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return luuPhim;
    }

    public ArrayList<Rating> loadEdgeList(String ratingPath) {
        ArrayList<Rating> LuuDanhgia=new ArrayList<>();

        try{
            File mofile=new File(ratingPath);
            Scanner docfile=new Scanner(mofile);

            if(docfile.hasNextLine()){
                docfile.nextLine();
            }

            while(docfile.hasNextLine()){
                String dong=docfile.nextLine();
                String[] TachThongTin=dong.split(",");
                int MaNguoiXem=Integer.parseInt(TachThongTin[0]);
                int MaPhim=Integer.parseInt(TachThongTin[1]);
                int SaoDanhGia=Integer.parseInt(TachThongTin[2]);
                long DauThoiGian=Long.parseLong(TachThongTin[3]);
                LuuDanhgia.add(new Rating(MaNguoiXem, MaPhim, SaoDanhGia, DauThoiGian));
            }
            docfile.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return LuuDanhgia;
    }
    //khongchinhsua
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    //khongchinhsua
    public ArrayList<User> getUsers() {
        return users;
    }
    //khongchinhsua
    public ArrayList<Rating> getRating() {
        return ratings;
    }

    // @Requirement 2
    public ArrayList<Movie> findMoviesByNameAndMatchRating(int userId, int rating) {
        ArrayList<Movie> DanhSachPhim=new ArrayList<>();
        ArrayList<String> LuuTenPhim=new ArrayList<>();

        //Tim phim
        for(Rating timphim:ratings) {
            if(timphim.getMaNguoiXem()==userId && timphim.getSaoDanhGia()>=rating){
                for(Movie movie:movies) {
                    if(movie.getId()==timphim.getIDPhim()){
                        LuuTenPhim.add(movie.getName());
                        break;
                    }
                }
            }
        }

        //sắp xếp theo tên
        for(int i=0; i<LuuTenPhim.size()-1; i++){
            for(int j=0; j<LuuTenPhim.size()-i-1; j++){
                if(LuuTenPhim.get(j).compareTo(LuuTenPhim.get(j+1))>0){
                    String temp=LuuTenPhim.get(j);
                    LuuTenPhim.set(j, LuuTenPhim.get(j+1));
                    LuuTenPhim.set(j+1, temp);
                }
            }
        }
        
        //thêm vào arraylist dựa vào sắp xếp tên phim đã làm
        for(String tenPhim:LuuTenPhim){
            for(Movie Phim:movies){
                if(Phim.getName().equals(tenPhim)){
                    DanhSachPhim.add(Phim);
                    break;
                }
            }
        }

        return DanhSachPhim;
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {
        ArrayList<User> DanhSachNguoiXem=new ArrayList<>();

        boolean CheckDiemDanhGia=false;
        int DiemDanhGia=0;

        //tìm điểm đánh giá của người xem userId
        for(Rating danhgia:ratings){
            if(danhgia.getMaNguoiXem()==userId && danhgia.getIDPhim()==movieId){
                DiemDanhGia=danhgia.getSaoDanhGia();
                CheckDiemDanhGia=true;
                break;
            }
        }

        //Tìm những người đánh giá
        if(CheckDiemDanhGia) {
            for(Rating danhgia:ratings) {
                if(danhgia.getIDPhim()==movieId && danhgia.getSaoDanhGia()==DiemDanhGia){
                    for(User nguoiXem:users){
                        if(nguoiXem.getId()==danhgia.getMaNguoiXem()){
                            if(nguoiXem.getId()!=userId){
                                DanhSachNguoiXem.add(nguoiXem);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return DanhSachNguoiXem;
    }

    // Requirement 4
    public ArrayList<String> findMoviesNameHavingSameReputation() {
        ArrayList<String> LuuPhim=new ArrayList<>();
        ArrayList<Integer> LuuMaPhim=new ArrayList<>();
        ArrayList<Integer> DiemDanhGia=new ArrayList<>();

        //Tim Những người đánh giá phim > 3 sao
        for(Rating DanhGia:ratings){
            if(DanhGia.getSaoDanhGia()>3){
                int maPhim=DanhGia.getIDPhim();
                int vt=LuuMaPhim.indexOf(maPhim);
                if(vt==-1){
                    LuuMaPhim.add(maPhim);
                    DiemDanhGia.add(1);
                }else{
                    int dem=DiemDanhGia.get(vt);
                    DiemDanhGia.set(vt, dem+1);
                }
            }
        }

        //Tìm Phim
        for(int i=0; i<LuuMaPhim.size(); i++){
            int MaPhim=LuuMaPhim.get(i);
            int SoNguoiXem=DiemDanhGia.get(i);
            if(SoNguoiXem>=2){
                for(Movie Phim:movies){
                    if(Phim.getId()==MaPhim){
                        LuuPhim.add(Phim.getName());
                        break;
                    }
                }
            }
        }

        //sắp xếp theo chữ cái
        for(int i=0; i<LuuPhim.size()-1; i++){
            for(int j=0; j<LuuPhim.size()-i-1; j++){
                if(LuuPhim.get(j).compareTo(LuuPhim.get(j+1))>0){
                    String temp=LuuPhim.get(j);
                    LuuPhim.set(j, LuuPhim.get(j+1));
                    LuuPhim.set(j+1, temp);
                }
            }
        }

        return LuuPhim;
    }



    // Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) {
        ArrayList<String> LuuPhim=new ArrayList<>();
        ArrayList<Integer> LuuMaPhim=new ArrayList<>();
        ArrayList<User> NguoiDungSame=new ArrayList<>();
        ArrayList<String> Luukphim = new ArrayList<>();

        // Tìm những người cùng same giới và nghề, cùng phim và cùng số sao
        for(User NguoiXEM:users){
            if(NguoiXEM.getOccupation().equals(occupation) && NguoiXEM.getGender().equals(gender)){
                NguoiDungSame.add(NguoiXEM);
            }
        }

        for(User user:NguoiDungSame) {
            int Manguoixem=user.getId();
            for(Rating abb:ratings) {
                if(abb.getMaNguoiXem()==Manguoixem && abb.getSaoDanhGia()==rating){
                    int Maphim=abb.getIDPhim();
                    if(!LuuMaPhim.contains(Maphim)) 
                        LuuMaPhim.add(Maphim); 
                }
            }
        }

        //Tìm tên phim lưu vào arraylist đã tạo
        for(Integer Maphim:LuuMaPhim){
            for(Movie phim:movies){
                if(phim.getId()==Maphim){
                    LuuPhim.add(phim.getName());
                    break;
                }
            }
        }

        // Sắp xếp theo tên
        for(int i=0; i<LuuPhim.size()-1; i++){
            for(int j=0; j<LuuPhim.size()-i-1; j++){
                if(LuuPhim.get(j).compareTo(LuuPhim.get(j+1))>0){
                    String temp=LuuPhim.get(j);
                    LuuPhim.set(j, LuuPhim.get(j+1));
                    LuuPhim.set(j+1, temp);
                }
            }
        }

        // Chỉ trả về k phim
        for(int i = 0; i < LuuPhim.size() && i < k; i++) {
            Luukphim.add(LuuPhim.get(i));
        }

        return Luukphim;
    }


    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        ArrayList<String> LuuPhim=new ArrayList<>();
        ArrayList<Integer> LuuMaPhim=new ArrayList<>();
        ArrayList<User> NguoiDungSameNgheNghiep=new ArrayList<>();
        ArrayList<String> Luukphim = new ArrayList<>();

        for(User NguoiXem:users) {
            if(NguoiXem.getOccupation().equals(occupation)){
                NguoiDungSameNgheNghiep.add(NguoiXem);
            }
        }

        //lưu mã phim của những người xem cùng nghèe nghiệp <rating lưu vào arralisth
        for(User user:NguoiDungSameNgheNghiep){
            int userId=user.getId();
            for(Rating danhgia:ratings){
                if(danhgia.getMaNguoiXem()==userId && danhgia.getSaoDanhGia()<rating){
                    int movieId=danhgia.getIDPhim();
                    if(!LuuMaPhim.contains(movieId)) 
                        LuuMaPhim.add(movieId); 
                }
            }
        }

        //Tim phim
        for(Integer MaPhim:LuuMaPhim){
            for(Movie Phim:movies){
                if(Phim.getId()==MaPhim){
                    LuuPhim.add(Phim.getName());
                    break;
                }
            }
        }

        //sắp xếp theo tên
        for(int i=0; i<LuuPhim.size()-1; i++){
            for(int j=0; j<LuuPhim.size()-i-1; j++){
                if(LuuPhim.get(j).compareTo(LuuPhim.get(j+1))>0){
                    String temp=LuuPhim.get(j);
                    LuuPhim.set(j, LuuPhim.get(j+1));
                    LuuPhim.set(j+1, temp);
                }
            }
        }

        for(int i = 0; i < LuuPhim.size() && i < k; i++) {
            Luukphim.add(LuuPhim.get(i));
        }

        return Luukphim;
    }

    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        ArrayList<User> NguoiDungSameNgheNghiep=new ArrayList<>();
        ArrayList<Movie> DanhSachMovieMoi=new ArrayList<>(movies);
        ArrayList<String> SapXepTenPhim=new ArrayList<>();
        ArrayList<Integer> MaPhimTrungTheLoai=new ArrayList<>();
        ArrayList<Integer> LuuMaPhim=new ArrayList<>();
        ArrayList<String> LuuPhim=new ArrayList<>();
        ArrayList<String> TheLoai=new ArrayList<>();
        long ThoiGianCoiNhieuNhat=0;

        for(int i=0; i<DanhSachMovieMoi.size(); i++) {
            SapXepTenPhim.add(DanhSachMovieMoi.get(i).getName());
        }

        for(int i=0; i<SapXepTenPhim.size(); i++){
            for(int j=i+1; j<SapXepTenPhim.size(); j++){
                if(SapXepTenPhim.get(i).compareTo(SapXepTenPhim.get(j))>0){
                    String temp=SapXepTenPhim.get(i);
                    SapXepTenPhim.set(i, SapXepTenPhim.get(j));
                    SapXepTenPhim.set(j, temp);
                }
            }
        }

        for(User NguoiXem:users){
            if(NguoiXem.getGender().equals(users.get(userId).getGender()) && NguoiXem.getId()!=userId){
                NguoiDungSameNgheNghiep.add(NguoiXem);
            }
        }

        for(Rating danhgia:ratings){
            if(danhgia.getMaNguoiXem()==userId && danhgia.getSaoDanhGia()>=rating && danhgia.getDauThoiGian()>ThoiGianCoiNhieuNhat){
                ThoiGianCoiNhieuNhat=danhgia.getDauThoiGian();
            }
        }

        for(Rating danhgia:ratings){
            if(danhgia.getMaNguoiXem()==userId&&danhgia.getDauThoiGian()==ThoiGianCoiNhieuNhat){
                for(Movie phim:movies){
                    if(phim.getId()==danhgia.getIDPhim()){
                        for(String theloai:phim.getGenres()){
                            if(!TheLoai.contains(theloai)){
                                TheLoai.add(theloai);
                            }
                        }
                    }
                }
            }
        }

        for(String tencuaphim:SapXepTenPhim){
            for(Movie phim:movies){
                if(phim.getName().equals(tencuaphim)){
                    for(String genre:phim.getGenres()){
                        if(TheLoai.contains(genre)){
                            MaPhimTrungTheLoai.add(phim.getId());
                            break;
                        }
                    }
                    break;
                }
            }
        }

        int dem=0;
        for(Integer maPhim:MaPhimTrungTheLoai){
            for(Rating dangia:ratings){
                if(dangia.getSaoDanhGia()>= rating && NguoiDungSameNgheNghiep.contains(users.get(dangia.getMaNguoiXem()))){
                    if(dangia.getIDPhim()== maPhim){
                        LuuMaPhim.add(maPhim);
                        dem++;
                        break;
                    }
                }
                if (dem==k) {
                    break;
                }
            }
            if (dem==k) {
                break;
            }
        }

        for(Integer MaPhim:LuuMaPhim){
            for(Movie Phim:movies){
                if(Phim.getId()==MaPhim){
                    LuuPhim.add(Phim.getName());
                    break;
                }
            }
        }



        
        return LuuPhim;
    }

}
