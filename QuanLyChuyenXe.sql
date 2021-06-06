DROP DATABASE IF EXISTS rams;
CREATE DATABASE rams;
USE rams;
​
create table loai_ghe
(
    ma_loai_ghe  varchar(10)  not null
        primary key,
    ten_loai_ghe varchar(100) null
);
​
create table loai_xe
(
    ma_loai_xe  varchar(10) not null
        primary key,
    so_cho_ngoi int         null
);
​
create table nha_xe
(
    ma_nha_xe  varchar(10)  not null
        primary key,
    ten_nha_xe varchar(500) null
);
​
create table roles
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);
​
create table tinh_thanh
(
    ma_tinh  varchar(10) not null
        primary key,
    ten_tinh varchar(10) null
);
​
create table ben
(
    ma_ben  varchar(10) not null
        primary key,
    ten_ben varchar(25) null,
    ma_tinh varchar(10) null,
    constraint ben_ibfk_1
        foreign key (ma_tinh) references tinh_thanh (ma_tinh)
);
​
create index ma_tinh
    on ben (ma_tinh);
​
create table trang_thai_ghe
(
    ma_trang_thai  varchar(10)  not null
        primary key,
    ten_trang_thai varchar(100) null
);
​
create table users
(
    id            bigint auto_increment
        primary key,
    dia_chi       varchar(255) null,
    email         varchar(255) null,
    gioi_tinh     bit          not null,
    ngay_sinh     date         null,
    password      varchar(255) null,
    so_dien_thoai varchar(255) null,
    ten           varchar(255) null,
    username      varchar(255) null,
    verification_code    varchar(100) null,
    constraint UK6dotkott2kjsp8vw4d0m25fb7
        unique (email),
    constraint UKr43af9ap4edm43mmtq01oddj6
        unique (username)
);
​
create table user_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id)
);
​
create table xe
(
    ma_xe      varchar(10) not null
        primary key,
    bien_so_xe varchar(10) null,
    ma_loai_xe varchar(10) null,
    ma_nha_xe  varchar(10) null,
    constraint xe_ibfk_1
        foreign key (ma_nha_xe) references nha_xe (ma_nha_xe),
    constraint xe_ibfk_2
        foreign key (ma_loai_xe) references loai_xe (ma_loai_xe)
);
​
create table chuyen_xe
(
    ma_chuyen varchar(10)  not null
        primary key,
    ma_xe     varchar(10)  null,
    ben_di    varchar(200) null,
    ben_den   varchar(200) null,
    thoi_gian datetime     null,
    constraint chuyen_xe_ibfk_1
        foreign key (ma_xe) references xe (ma_xe),
    constraint chuyen_xe_ibfk_2
        foreign key (ben_den) references ben (ma_ben),
    constraint chuyen_xe_ibfk_3
        foreign key (ben_di) references ben (ma_ben)
);
​
create index ben_den
    on chuyen_xe (ben_den);
​
create index ben_di
    on chuyen_xe (ben_di);
​
create index ma_xe
    on chuyen_xe (ma_xe);
​
create table ghe
(
    ma_ghe        varchar(10) not null
        primary key,
    ma_xe         varchar(10) null,
    ma_loai_ghe   varchar(10) null,
    ma_trang_thai varchar(10) null,
    gia 	  float	      null,
    hang	  int	      null,
    so_ghe	  int         null,
    tang	  int 	      null,
    constraint ghe_ibfk_1
        foreign key (ma_xe) references xe (ma_xe),
    constraint ghe_ibfk_2
        foreign key (ma_loai_ghe) references loai_ghe (ma_loai_ghe),
    constraint ghe_ibfk_3
        foreign key (ma_trang_thai) references trang_thai_ghe (ma_trang_thai)
);
​
create index ma_loai_ghe
    on ghe (ma_loai_ghe);
​
create index ma_trang_thai
    on ghe (ma_trang_thai);
​
create index ma_xe
    on ghe (ma_xe);
​
create table ve_xe
(
    ma_ve               varchar(10)  not null
        primary key,
    ma_tai_khoan_nha_xe bigint       null,
    ma_chuyen           varchar(10)  null,
    thoi_gian           datetime     null,
    ma_nguoi_dung       bigint       null,
    gia_tien            float        null,
    ma_ghe              varchar(10)  null,
    ma_nha_xe           varchar(255) null,
    ma_chuyen_xe        varchar(255) null,
    is_thanh_toan       bit          not null,
    constraint FKmqbvtki5mrujl6yvmbxrmc8x5
        foreign key (ma_chuyen_xe) references chuyen_xe (ma_chuyen),
    constraint ve_xe_ibfk_1
        foreign key (ma_ghe) references ghe (ma_ghe),
    constraint ve_xe_ibfk_2
        foreign key (ma_chuyen) references chuyen_xe (ma_chuyen),
    constraint ve_xe_users_id_fk
        foreign key (ma_tai_khoan_nha_xe) references users (id),
    constraint ve_xe_users_id_fk_2
        foreign key (ma_nguoi_dung) references users (id)
);
​
create index ma_chuyen
    on ve_xe (ma_chuyen);
​
create index ma_ghe
    on ve_xe (ma_ghe);
​
create index ma_loai_xe
    on xe (ma_loai_xe);
​
create index ma_nha_xe
    on xe (ma_nha_xe);
​
INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_MODERATOR');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (4, 'ROLE_NHAXE');
INSERT INTO roles (id, name) VALUES (5, 'ROLE_TRUYVET');

INSERT INTO loai_ghe (ma_loai_ghe, ten_loai_ghe) VALUES ('mlg01', 'Thường');
INSERT INTO loai_ghe (ma_loai_ghe, ten_loai_ghe) VALUES ('mlg02', 'Vip');

INSERT INTO trang_thai_ghe (ma_trang_thai, ten_trang_thai) VALUES ('mttg00', 'Không tồn tại');
INSERT INTO trang_thai_ghe (ma_trang_thai, ten_trang_thai) VALUES ('mttg01', 'Trống');
INSERT INTO trang_thai_ghe (ma_trang_thai, ten_trang_thai) VALUES ('mttg02', 'Đang chọn');
INSERT INTO trang_thai_ghe (ma_trang_thai, ten_trang_thai) VALUES ('mttg03', 'Đã Đặt');
INSERT INTO trang_thai_ghe (ma_trang_thai, ten_trang_thai) VALUES ('mttg04', 'Đang Ngồi');

INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt01', 'Quảng Bình');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt02', 'Quảng Ngãi');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt03', 'Quảng Trị');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt04', 'Hà Nội');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt05', 'Gia Lai');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt06', 'Huế');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt07', 'Bình Định');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt08', 'Đắk Lắk');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt09', 'Lâm Đồng');
INSERT INTO tinh_thanh (ma_tinh, ten_tinh) VALUES ('mt10', 'Sài Gòn');

INSERT INTO loai_xe (ma_loai_xe, so_cho_ngoi) VALUES ('mlx01', 16);
INSERT INTO loai_xe (ma_loai_xe, so_cho_ngoi) VALUES ('mlx02', 29);
INSERT INTO loai_xe (ma_loai_xe, so_cho_ngoi) VALUES ('mlx03', 35);
INSERT INTO loai_xe (ma_loai_xe, so_cho_ngoi) VALUES ('mlx04', 36);
INSERT INTO loai_xe (ma_loai_xe, so_cho_ngoi) VALUES ('mlx05', 47);

INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx01', 'Chín Nghĩa 1');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx02', 'Phương Trang');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx03', 'Sơn Tùng');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx04', 'Chín Nghĩa');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx05', 'Hoàng Long');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx06', 'Chín Nghĩa');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx07', 'Cúc Tùng');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx08', 'Hùng Cúc');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx09', 'Mỹ Linh');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx10', 'Minh Long');
INSERT INTO nha_xe (ma_nha_xe, ten_nha_xe) VALUES ('mnx11', 'Minh Hạnh');

INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb01', 'Đồng Hới', 'mt01');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb02', 'Nam Lý', 'mt01');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb03', 'Ba Đồn', 'mt01');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb04', 'Đồng Lê', 'mt01');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb05', 'Quy Đạt', 'mt01');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb06', 'Lệ Thuỷ', 'mt01');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb07', 'Quảng Ngãi', 'mt02');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb08', 'Bắc Quảng Ngãi', 'mt02');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb09', 'Chín Nghĩa', 'mt02');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb10', 'Văn Vinh', 'mt02');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb11', 'Cổ Phần Quảng Ngãi', 'mt02');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb12', 'Đông Hà', 'mt03');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb13', 'Cầu Trắng', 'mt03');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb14', 'Hải Lăng', 'mt03');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb15', 'Hồ Xá', 'mt03');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb16', 'Khe Sanh', 'mt03');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb17', 'Kim Mã', 'mt04');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb18', 'Long Biên', 'mt04');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb19', 'Yên Phụ', 'mt04');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb20', 'Lương Yên', 'mt04');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb21', 'Mỹ Đình', 'mt04');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb22', 'Hải Lăng', 'mt05');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb23', 'Chư Sê', 'mt05');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb24', 'Ayunpa', 'mt05');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb25', 'Đắk Đoa', 'mt05');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb26', 'An Khê', 'mt05');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb27', 'Đông Ba', 'mt06');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb28', 'Nguyễn Hoàng', 'mt06');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb29', 'Phía Nam', 'mt06');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb30', 'Phía Bắc', 'mt06');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb31', 'Hoàng Long', 'mt06');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb32', 'Phù Mỹ', 'mt07');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb33', 'Liên Tỉnh Bình Định', 'mt07');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb34', 'Bồng Sơn', 'mt07');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb35', 'Quy Nhơn', 'mt07');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb36', 'Phù Cát', 'mt07');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb37', 'Buôn Ma Thuột', 'mt08');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb38', 'Buôn Hồ', 'mt08');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb39', 'Krông Năng', 'mt08');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb40', 'Eakar', 'mt08');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb41', 'Quyết Thắng', 'mt08');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb42', 'Liên tỉnh Đà Lạt', 'mt09');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb43', 'Đức Long Bảo Lộc', 'mt09');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb44', 'Đức Trọng', 'mt09');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb45', 'Phương Trang', 'mt09');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb46', 'Thành Bưởi', 'mt09');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb47', 'Miền Tây', 'mt10');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb48', 'Chợ Lớn', 'mt10');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb49', 'Tân Phú', 'mt10');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb50', 'An Sương', 'mt10');
INSERT INTO ben (ma_ben, ten_ben, ma_tinh) VALUES ('mb51', 'Miền Đông', 'mt10');


INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (1, null, 'nhan0095aa@gmail.com', false, null, '$2a$10$Nptv1Kn/eX5RfQdEf1gkaOQ/fbosj/CuDHRwOBgebybEM28Ha/eHe', '0987654321', null, 'nhan', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (2, null, 'nhan00fe925@gmail.com', false, null, '$2a$10$vxFDuvTYfqfwWVq4N8wqGuIB.njagqgnRLLrLpRQjJ5l36eRc/QdS', '091234567', 'Tran Viet Nhan', 'nhan12212', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (3, null, '3323@gmail.com', false, null, '$2a$10$asCoTiavKlj6muVIj5AYaeKb7.1TOvFDYHNxzjshrx3NdJ1wzjnLS', '091234567', 'Tran Viet Nhan', 'nhan1221222', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (4, null, '3632323@gmail.com', false, null, '$2a$10$sZ32VrToUWShqpN0E6gRlu1F7Zf5lYJlrbnIRkfTfmSDkNik343kO', '091234567', 'Tran Viet Nhan', 'nhan241222', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (5, null, '3642323@gmail.com', false, null, '$2a$10$6pdx4CbfNwtmb6ID5nmv7.5lDtM95EadQFv83Zmk5qyzgxbeyLf6y', '091234567', 'Tran Viet Nhan', 'nhan2413422', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (6, null, '364w32323@gmail.com', false, null, '$2a$10$knQoMtveSHCgHfnIRovSrONSE.3qAu3ednOloNuNENOqP3xpQ9kre', '091234567', 'Tran Viet Nhan', 'nhan13422', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (7, null, '364w32323a@gmail.com', false, null, '$2a$10$HVolDmG2L/Q9FZ3uC.9vAe8mp6oKwP4HLPSgBdcWGYAvb1BsQlRQ6', '091234567', 'Tran Viet Nhan', 'nhan134s22', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (8, '301 OID', '364wv32323a@gmail.com', false, null, '$2a$10$PR5uzSyA/3fBZjuZ78PMq.rGJtKR2L5GDG/jqlkI2t26lYiRxXwD2', '091234567', 'Tran Viet Nhan', 'nhan1324s22', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (9, '301 OID', '364wv32g323a@gmail.com', false, '1999-07-14', '$2a$10$zwsRt53DSMLToprsl19w8ewGNsqY41MsMcH17H8ZCBBM8g8eJa3Wm', '091234567', 'Tran Viet Nhan', 'nhan1324s2f2', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (10, null, 'fasdf@gmail.com', false, null, '$2a$10$9sQxImtdeJDwfLvxsgN5lu8.Zu9KX4cRRHgx55nFOtpkAljXLaGWm', null, 'asdf', null, null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (11, '301 OID', 'nhantest@gmail.com', false, '1999-07-14', '$2a$10$20Z4.OiaqvAQ5k2iJ1G7Qe1zuZLQ5JXSlRsOg9s4ITd613SoG74s.', '091234567', 'Tran Viet Nhan', 'nhan12', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (12, 'quang binh', 'nhantest1@gmail.com', false, null, '$2a$10$S7xbgKFCblwoumbweOPhwey8Q/W.e9iS3s6UQy8OB98hNrvC9Niqa', '0941371807', '', 'nhan331', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (13, 'quang binh', 'nhan009523@gmail.com', false, null, '$2a$10$xuxmuR9cAIXlAJrJWiriuesHcVB/BM9ZUG6HR7i8GrfTPVRb7BUYe', '0941371807', '', 'nhan123', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (14, 'quang binh', 'nhan009512@gmail.com', false, null, '$2a$10$TYruRa4aT7mH3ZrVzGkhWetzClE1hH3y6c8g80VV9DFu1EpZsGVRi', '0941371807', '', 'nhan1233', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (15, '233 trung nu vuong', 'tritcm@rikkeisoft.com', false, null, '$2a$10$DAKZqlgvihVKK7rCH/CcR.71VugMYrf1Sb7RKXj0zQgjQaXdazZNq', '0934954589', '', 't', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (16, 'qb', 'nhan0095test@gmail.com', false, null, '$2a$10$RRSYyhcTSSs2MiuKTZGdKeIr5VJBQkhUzB8B1gemO49zOIdn2lW1q', '0987654321', '', 'nhantest', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (17, null, 'admin1@gmail.com', false, null, '$2a$10$06xhMnMsCO6JurOZrqeF.e29PBPzfE0iWYOdmP.NC25rq8nqE.hyG', '', '', 'admin1', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (18, null, 'nhan0095testTrungTIn@gmail.com', false, null, '$2a$10$qwB9Nr5VUJh0BlyjgX1d3ucjPMrbxNrvpOsQgFfD2K9vubhPz/NOu', '0987654323', '', 'trungtin', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (19, null, '2343s@gmail.com', false, null, '$2a$10$ekYcfiBXb9ZaxTs/KtzJgO0yyInaFFnBsm5h2O4K6xjUWOT3HI5g6', '0987654321', '', 'lamhue', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (20, null, 'nhantv_tt32s@rikkeisoft.com', false, null, '$2a$10$fsruciVAkD2z72jyqczkBOMdTCBqLZ8iFQNx/DePLpcUccBmwwk9q', '0987654321', '', 'nhan234', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (21, 'QB', 'nsasdf@gmail.com', false, null, '$2a$10$/vghafaupzFOa2lO/z1dlOcoOzX4IdeI/caiXu92PwKg23ZLK780e', '0987654321', '', 'nhan235', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (22, null, 'nhantv_tt3232s@rikkeisoft.com', false, null, '$2a$10$E/zY5jWPxVY6yDR5vgdsCebGdY5ogiymiAgKJ4PibF8GB2YkRqGeW', '0987654321', '', 'nhanff', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (23, null, 'admin@gmail.com', false, null, '$2a$10$F/CO9YEvE8Y5z5l4R7xVDegR1/whJqWi..WdCiwS/SpRrz/eZIuAq', '', '', 'admin', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (25, null, 'nhan00fe9245@gmail.com', false, null, '$2a$10$dezLXqlI6.QoMJLem5Hsq.83rr3ink0meIv6bUXQc3lbYpbb7pjmq', '0987654321', '', 'minhlong', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (26, null, 'nhan0095@gmail.com', false, null, '$2a$10$7DqQU0BkFdz/TiSffzHUouAmM5Lm6dr0B6NgrcmRJ4uHzObFxQUmW', null, null, 'nhan0095@gmail.com', null);
INSERT INTO rams.users (id, dia_chi, email, gioi_tinh, ngay_sinh, password, so_dien_thoai, ten, username, verification_code) VALUES (27, null, 'adfdf@gmail.com', false, null, '$2a$10$e8mF4Ifg5mjHFSPlWFIIEeqs1AGMEEx5HWO5cwSRVi8ye3Ga39UVq', '0987654321', '', 'testeas', null);

INSERT INTO rams.user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (2, 5);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (3, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (3, 5);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (4, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (4, 5);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (5, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (5, 5);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (6, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (6, 5);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (7, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (7, 5);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (8, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (8, 5);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (9, 5);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (10, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (11, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (12, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (13, 4);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (14, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (15, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (16, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (17, 3);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (18, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (19, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (20, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (21, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (22, 4);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (23, 3);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (25, 4);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (26, 1);
INSERT INTO rams.user_roles (user_id, role_id) VALUES (27, 1);

INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx01', '76B-21542', 'mlx05', 'mnx01');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx02', '53S-54212', 'mlx02', 'mnx02');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx03', '51B-17268', 'mlx03', 'mnx04');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx04', '73B-03655', 'mlx04', 'mnx10');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx05', '79B-01217', 'mlx01', 'mnx07');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx06', '37B-01908', 'mlx02', 'mnx08');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx07', '77B-01240', 'mlx04', 'mnx03');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx08', '79D-5634', 'mlx05', 'mnx05');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx09', '76B-21542', 'mlx05', 'mnx06');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx10', '53S-54212', 'mlx02', 'mnx09');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx11', '51B-17268', 'mlx03', 'mnx11');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx12', '73B-03655', 'mlx04', 'mnx06');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx13', '79B-01217', 'mlx01', 'mnx09');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx14', '37B-01908', 'mlx02', 'mnx11');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx15', '77B-01240', 'mlx04', 'mnx04');
INSERT INTO xe (ma_xe, bien_so_xe, ma_loai_xe, ma_nha_xe) VALUES ('mx16', '79D-5634', 'mlx05', 'mnx03');

INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx01', 'mx01', 'mb03', 'mb01', '2021-12-21 03:30:12');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx02', 'mx02', 'mb02', 'mb03', '2021-02-20 04:34:21');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx03', 'mx03', 'mb04', 'mb03', '2021-01-19 05:32:43');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx04', 'mx04', 'mb01', 'mb05', '2021-04-08 07:45:12');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx05', 'mx05', 'mb05', 'mb06', '2021-02-12 12:12:21');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx06', 'mx06', 'mb02', 'mb03', '2021-05-21 11:11:12');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx07', 'mx07', 'mb07', 'mb01', '2021-03-13 15:35:32');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx08', 'mx08', 'mb02', 'mb02', '2021-02-28 19:54:23');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx09', 'mx03', 'mb01', 'mb04', '2021-01-12 18:43:12');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx10', 'mx03', 'mb02', 'mb04', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx11', 'mx01', 'mb02', 'mb03', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx12', 'mx02', 'mb04', 'mb09', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx13', 'mx04', 'mb05', 'mb08', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx14', 'mx05', 'mb01', 'mb06', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx15', 'mx06', 'mb02', 'mb03', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx16', 'mx07', 'mb06', 'mb04', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx17', 'mx08', 'mb07', 'mb05', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx18', 'mx06', 'mb09', 'mb08', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx19', 'mx04', 'mb08', 'mb07', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx20', 'mx02', 'mb03', 'mb02', '2021-04-11 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx21', 'mx01', 'mb02', 'mb03', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx22', 'mx02', 'mb04', 'mb09', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx23', 'mx04', 'mb05', 'mb08', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx24', 'mx05', 'mb01', 'mb06', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx25', 'mx06', 'mb02', 'mb03', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx26', 'mx07', 'mb06', 'mb04', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx27', 'mx08', 'mb07', 'mb05', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx28', 'mx06', 'mb09', 'mb08', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx29', 'mx04', 'mb08', 'mb07', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx30', 'mx02', 'mb03', 'mb02', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx31', 'mx01', 'mb02', 'mb11', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx32', 'mx02', 'mb04', 'mb12', '2021-04-17 00:00:00');
INSERT INTO chuyen_xe (ma_chuyen, ma_xe, ben_di, ben_den, thoi_gian) VALUES ('mcx33', 'mx04', 'mb05', 'mb13', '2021-04-17 00:00:00');

INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg0000', null, null, 'mttg01', 0, 0, 0, 0);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg01', 'mx04', 'mlg01', 'mttg01', 150000, 1, 1, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg02', 'mx04', 'mlg01', 'mttg01', 150000, 1, 2, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg03', 'mx04', 'mlg01', 'mttg01', 150000, 1, 3, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg04', 'mx04', 'mlg01', 'mttg01', 150000, 2, 4, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg05', 'mx04', 'mlg01', 'mttg01', 150000, 2, 5, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg06', 'mx04', 'mlg01', 'mttg01', 150000, 2, 6, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg07', 'mx04', 'mlg01', 'mttg01', 150000, 3, 7, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg08', 'mx04', 'mlg01', 'mttg01', 150000, 3, 8, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg09', 'mx04', 'mlg01', 'mttg01', 150000, 3, 9, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg10', 'mx04', 'mlg01', 'mttg01', 150000, 4, 10, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg11', 'mx04', 'mlg01', 'mttg01', 150000, 4, 11, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg12', 'mx04', 'mlg01', 'mttg01', 150000, 4, 12, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg13', 'mx04', 'mlg01', 'mttg01', 150000, 5, 13, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg14', 'mx04', 'mlg01', 'mttg01', 150000, 5, 14, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg15', 'mx04', 'mlg01', 'mttg01', 150000, 5, 15, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg16', 'mx04', 'mlg01', 'mttg01', 150000, 6, 16, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg17', 'mx04', 'mlg01', 'mttg01', 150000, 6, 17, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg18', 'mx04', 'mlg01', 'mttg01', 150000, 6, 18, 1);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg19', 'mx04', 'mlg01', 'mttg01', 150000, 1, 19, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg20', 'mx04', 'mlg01', 'mttg01', 150000, 1, 20, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg21', 'mx04', 'mlg01', 'mttg01', 150000, 1, 21, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg22', 'mx04', 'mlg01', 'mttg01', 150000, 2, 22, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg23', 'mx04', 'mlg01', 'mttg01', 150000, 2, 23, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg24', 'mx04', 'mlg01', 'mttg01', 150000, 2, 24, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg25', 'mx04', 'mlg01', 'mttg01', 150000, 3, 25, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg26', 'mx04', 'mlg01', 'mttg01', 150000, 3, 26, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg27', 'mx04', 'mlg01', 'mttg01', 150000, 3, 27, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg28', 'mx04', 'mlg01', 'mttg01', 150000, 4, 28, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg29', 'mx04', 'mlg01', 'mttg01', 150000, 4, 29, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg30', 'mx04', 'mlg01', 'mttg01', 150000, 4, 30, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg31', 'mx04', 'mlg01', 'mttg01', 150000, 5, 31, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg32', 'mx04', 'mlg01', 'mttg01', 150000, 5, 32, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg33', 'mx04', 'mlg01', 'mttg01', 150000, 5, 33, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg34', 'mx04', 'mlg01', 'mttg01', 150000, 6, 34, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg35', 'mx04', 'mlg01', 'mttg01', 150000, 6, 35, 2);
INSERT INTO rams.ghe (ma_ghe, ma_xe, ma_loai_ghe, ma_trang_thai, gia, hang, so_ghe, tang) VALUES ('mg36', 'mx04', 'mlg01', 'mttg01', 150000, 6, 36, 2);

INSERT INTO rams.ve_xe (ma_ve, ma_tai_khoan_nha_xe, ma_chuyen, thoi_gian, ma_nguoi_dung, gia_tien, ma_ghe, ma_nha_xe, ma_chuyen_xe, is_thanh_toan) VALUES ('mv01', 2, 'mcx01', '2021-12-21 03:30:12', 1, 400000, 'mg01', '', null, false);
INSERT INTO rams.ve_xe (ma_ve, ma_tai_khoan_nha_xe, ma_chuyen, thoi_gian, ma_nguoi_dung, gia_tien, ma_ghe, ma_nha_xe, ma_chuyen_xe, is_thanh_toan) VALUES ('mv02', 2, 'mcx02', '2021-02-20 04:34:21', 1, 500000, 'mg02', '', null, false);
INSERT INTO rams.ve_xe (ma_ve, ma_tai_khoan_nha_xe, ma_chuyen, thoi_gian, ma_nguoi_dung, gia_tien, ma_ghe, ma_nha_xe, ma_chuyen_xe, is_thanh_toan) VALUES ('mv03', 2, 'mcx04', '2021-04-08 07:45:12', 1, 350000, 'mg05', '', null, false);
INSERT INTO rams.ve_xe (ma_ve, ma_tai_khoan_nha_xe, ma_chuyen, thoi_gian, ma_nguoi_dung, gia_tien, ma_ghe, ma_nha_xe, ma_chuyen_xe, is_thanh_toan) VALUES ('mv04', 2, 'mcx05', '2021-02-12 12:12:21', 1, 420000, 'mg06', '', null, false);
INSERT INTO rams.ve_xe (ma_ve, ma_tai_khoan_nha_xe, ma_chuyen, thoi_gian, ma_nguoi_dung, gia_tien, ma_ghe, ma_nha_xe, ma_chuyen_xe, is_thanh_toan) VALUES ('mv05', 2, 'mcx03', '2021-01-19 05:32:43', 1, 100000, 'mg03', '', null, false);
INSERT INTO rams.ve_xe (ma_ve, ma_tai_khoan_nha_xe, ma_chuyen, thoi_gian, ma_nguoi_dung, gia_tien, ma_ghe, ma_nha_xe, ma_chuyen_xe, is_thanh_toan) VALUES ('mv8212', 2, null, '2021-06-24 07:45:12', 1, 0, 'mg01', null, 'mcx04', true);