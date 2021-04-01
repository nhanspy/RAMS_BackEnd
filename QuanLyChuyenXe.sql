DROP DATABASE IF EXISTS rams;
CREATE DATABASE rams;
USE rams;
CREATE TABLE `loai_tk` (
                           `ma_loai` varchar(10) PRIMARY KEY NOT NULL,
                           `ten_loai` varchar(200)
);

CREATE TABLE `tai_khoan` (
                             `ma_tai_khoan` varchar(10) PRIMARY KEY NOT NULL,
                             `ma_loai` varchar(10),
                             `ten` nvarchar(500),
                             `so_dien_thoai` int,
                             `ngay_sinh` date,
                             `dia_chi` varchar(10),
                             `gioi_tinh` boolean,
                             `tai_khoan` varchar(100),
                             `mat_khau` varchar(100)
);

CREATE TABLE `nha_xe` (
                          `ma_nha_xe` varchar(10) PRIMARY KEY NOT NULL,
                          `ten_nha_xe` varchar(500)
);

CREATE TABLE `tinh_thanh` (
                              `ma_tinh` varchar(10) PRIMARY KEY NOT NULL,
                              `ten_tinh` varchar(10)
);

CREATE TABLE `ben` (
                       `ma_ben` varchar(10) PRIMARY KEY NOT NULL,
                       `ten_ben` varchar(10),
                       `ma_tinh` varchar(10)
);

CREATE TABLE `xe` (
                      `ma_xe` varchar(10) PRIMARY KEY NOT NULL,
                      `bien_so_xe` varchar(10),
                      `ma_loai_xe` varchar(10),
                      `ma_nha_xe` varchar(10)
);

CREATE TABLE `loai_xe` (
                           `ma_loai_xe` varchar(10) PRIMARY KEY NOT NULL,
                           `so_cho_ngoi` int
);

CREATE TABLE `chuyen_xe` (
                             `ma_chuyen` varchar(10) PRIMARY KEY NOT NULL,
                             `ma_xe` varchar(10),
                             `ben_di` varchar(200),
                             `ben_den` varchar(200),
                             `thoi_gian` datetime
);

CREATE TABLE `ve_xe` (
                         `ma_ve` varchar(10) PRIMARY KEY NOT NULL,
                         `ma_tai_khoan_nha_xe` varchar(10),
                         `ma_chuyen` varchar(10),
                         `thoi_gian` datetime,
                         `ma_nguoi_dung` varchar(10),
                         `gia_tien` float,
                         `ma_ghe` varchar(10)
);

CREATE TABLE `ghe` (
                       `ma_ghe` varchar(10) PRIMARY KEY NOT NULL,
                       `ma_xe` varchar(10),
                       `ma_loai_ghe` varchar(10),
                       `ma_trang_thai` varchar(10)
);

CREATE TABLE `loai_ghe` (
                            `ma_loai_ghe` varchar(10) PRIMARY KEY NOT NULL,
                            `ten_loai_ghe` varchar(100)
);

CREATE TABLE `trang_thai_ghe` (
                                  `ma_trang_thai` varchar(10) PRIMARY KEY NOT NULL,
                                  `ten_trang_thai` varchar(100)
);

ALTER TABLE `xe` ADD FOREIGN KEY (`ma_nha_xe`) REFERENCES `nha_xe` (`ma_nha_xe`);

ALTER TABLE `xe` ADD FOREIGN KEY (`ma_loai_xe`) REFERENCES `loai_xe` (`ma_loai_xe`);

ALTER TABLE `ben` ADD FOREIGN KEY (`ma_tinh`) REFERENCES `tinh_thanh` (`ma_tinh`);

ALTER TABLE `chuyen_xe` ADD FOREIGN KEY (`ma_xe`) REFERENCES `xe` (`ma_xe`);

ALTER TABLE `chuyen_xe` ADD FOREIGN KEY (`ben_den`) REFERENCES `ben` (`ma_ben`);

ALTER TABLE `chuyen_xe` ADD FOREIGN KEY (`ben_di`) REFERENCES `ben` (`ma_ben`);

ALTER TABLE `ve_xe` ADD FOREIGN KEY (`ma_ghe`) REFERENCES `ghe` (`ma_ghe`);

ALTER TABLE `ghe` ADD FOREIGN KEY (`ma_xe`) REFERENCES `xe` (`ma_xe`);

ALTER TABLE `ghe` ADD FOREIGN KEY (`ma_loai_ghe`) REFERENCES `loai_ghe` (`ma_loai_ghe`);

ALTER TABLE `ghe` ADD FOREIGN KEY (`ma_trang_thai`) REFERENCES `trang_thai_ghe` (`ma_trang_thai`);

ALTER TABLE `ve_xe` ADD FOREIGN KEY (`ma_chuyen`) REFERENCES `chuyen_xe` (`ma_chuyen`);

ALTER TABLE `tai_khoan` ADD FOREIGN KEY (`ma_loai`) REFERENCES `loai_tk` (`ma_loai`);

ALTER TABLE `ve_xe` ADD FOREIGN KEY (`ma_tai_khoan_nha_xe`) REFERENCES `tai_khoan` (`ma_tai_khoan`);

ALTER TABLE `ve_xe` ADD FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `tai_khoan` (`ma_tai_khoan`);

insert into tinh_thanh values ('mt01','Quảng Bình');
insert into tinh_thanh values ('mt02','Quảng Ngãi');
insert into tinh_thanh values ('mt03','Quảng Trị');
insert into tinh_thanh values ('mt04','Hà Nội');
insert into tinh_thanh values ('mt05','Gia Lai');

insert into ben values  ('mb01','Đồng Hới','mt01');
insert into ben values  ('mb02','Nam Lý','mt01');
insert into ben values  ('mb03','Ba Đồn','mt01');
insert into ben values  ('mb04','Đồng Lê','mt01');
insert into ben values  ('mb05','Quy Đạt','mt01');
insert into ben values  ('mb06','Lệ Thuỷ','mt01');
insert into ben values  ('mb07','Quảng Ngãi','mt02');
insert into ben values  ('mb08','Hải Lăng','mt03');
insert into ben values  ('mb09','Đông Hà','mt03');
insert into ben values  ('mb10','Lao Bảo','mt03');
insert into ben values  ('mb11','Mỹ Đình','mt04');
insert into ben values  ('mb12','Nước Ngầm','mt04');
insert into ben values  ('mb13','Yên Nghĩa','mt04');
insert into ben values  ('mb14','Đức Long','mt05');

insert into nha_xe values ('mnx01','Chín Nghĩa');
insert into nha_xe values ('mnx02','Phương Trang');
insert into nha_xe values ('mnx03','Sơn Tùng');
insert into nha_xe values ('mnx04','Chín Nghĩa');
insert into nha_xe values ('mnx05','Hoàng Long');
insert into nha_xe values ('mnx06','Chín Nghĩa');
insert into nha_xe values ('mnx07','Cúc Tùng');
insert into nha_xe values ('mnx08','Hùng Cúc');
insert into nha_xe values ('mnx09','Mỹ Linh');
insert into nha_xe values ('mnx10','Minh Long');
insert into nha_xe values ('mnx11','Minh Hạnh');



insert into trang_thai_ghe values ('mttg01','Trống');
insert into trang_thai_ghe values ('mttg02','Đã Đặt Chỗ');
insert into trang_thai_ghe values ('mttg03','Đang Ngồi');


insert into loai_xe values ('mlx01','16');
insert into loai_xe values ('mlx02','29');
insert into loai_xe values ('mlx03','35');
insert into loai_xe values ('mlx04','45');
insert into loai_xe values ('mlx05','47');

insert into loai_tk values ('mltk01','Truy vết');
insert into loai_tk values ('mltk02','Admin');
insert into loai_tk values ('mltk03','Nhà xe');
insert into loai_tk values ('mltk04','Người dùng');

insert into loai_ghe values ('mlg01','Thường');
insert into loai_ghe values ('mlg02','Vip');

insert into xe values ('mx01','76B-21542','mlx05','mnx01');
insert into xe values ('mx02','53S-54212','mlx02','mnx02');
insert into xe values ('mx03','51B-17268','mlx03','mnx04');
insert into xe values ('mx04','73B-03655','mlx04','mnx10');
insert into xe values ('mx05','79B-01217','mlx01','mnx07');
insert into xe values ('mx06','37B-01908','mlx02','mnx08');
insert into xe values ('mx07','77B-01240','mlx04','mnx03');
insert into xe values ('mx08','79D-5634','mlx05','mnx05');

insert into ghe values ('mg01','mx01','mlg01','mttg02');
insert into ghe values ('mg02','mx02','mlg02','mttg01');
insert into ghe values ('mg03','mx03','mlg02','mttg02');
insert into ghe values ('mg04','mx04','mlg01','mttg03');
insert into ghe values ('mg05','mx05','mlg02','mttg01');
insert into ghe values ('mg06','mx06','mlg01','mttg02');
insert into ghe values ('mg07','mx07','mlg02','mttg03');
insert into ghe values ('mg08','mx08','mlg02','mttg02');


insert into chuyen_xe values ('mcx01','mx01','mb03','mb01','2021-12-21 03:30:12');
insert into chuyen_xe values ('mcx02','mx02','mb02','mb03','2021-02-20 04:34:21');
insert into chuyen_xe values ('mcx03','mx03','mb04','mb03','2021-01-19 05:32:43');
insert into chuyen_xe values ('mcx04','mx04','mb01','mb05','2021-04-08 07:45:12');
insert into chuyen_xe values ('mcx05','mx05','mb05','mb06','2021-02-12 12:12:21');
insert into chuyen_xe values ('mcx06','mx06','mb02','mb03','2021-05-21 11:11:12');
insert into chuyen_xe values ('mcx07','mx07','mb07','mb01','2021-03-13 15:35:32');
insert into chuyen_xe values ('mcx08','mx08','mb02','mb02','2021-02-28 19:54:23');
insert into chuyen_xe values ('mcx09','mx03','mb01','mb04','2021-01-12 18:43:12');

insert into tai_khoan values ('mtk01','mltk01','Thảo','0323452414','2000-12-12','Hà Nội','0','null','null');
insert into tai_khoan values ('mtk02','mltk02','Kiên','0234343242','2001-10-01','Hải Phòng','1','null','null');
insert into tai_khoan values ('mtk03','mltk03','Anh','012244233','2003-11-02','Tây Ninh','0','null','null');
insert into tai_khoan values ('mtk04','mltk04','Đạt','023343243','1988-04-05','Lào Cai','1','null','null');
insert into tai_khoan values ('mtk05','mltk03','Hải','054543565','1999-01-12','Bắc Ninh','0','null','null');
insert into tai_khoan values ('mtk06','mltk02','Hoàng','023432423','1989-04-11','Sài Gòn','1','null','null');
insert into tai_khoan values ('mtk07','mltk03','Nhân','023434324','1999-03-13','Kon Tum','0','null','null');
insert into tai_khoan values ('mtk08','mltk01','Thắng','0234234234','2001-02-21','Gia Lai','1','null','null');
insert into tai_khoan values ('mtk09','mltk03','Hậu','025456546','2003-01-23','Sài Gòn','0','null','null');


insert into ve_xe values ('mv01','mtk01','mcx01','2021-12-21 03:30:12','mtk01','400000','mg01');
insert into ve_xe values ('mv02','mtk03','mcx02','2021-02-20 04:34:21','mtk03','500000','mg02');
insert into ve_xe values ('mv03','mtk03','mcx04','2021-04-08 07:45:12','mtk03','350000','mg05');
insert into ve_xe values ('mv04','mtk03','mcx05','2021-02-12 12:12:21','mtk03','420000','mg06');
insert into ve_xe values ('mv05','mtk03','mcx03','2021-01-19 05:32:43','mtk03','100000','mg03');





