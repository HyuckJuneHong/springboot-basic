drop table if exists tbl_vouchers_members;
drop table if exists tbl_vouchers;
drop table if exists tbl_members;

create table tbl_members
(
    member_id     varchar(50) not null unique,
    member_status varchar(50) not null,

    primary key (member_id)
);

create table tbl_vouchers
(
    voucher_id     varchar(50) not null unique,
    voucher_amount int         not null,
    voucher_policy varchar(50) not null,

    primary key (voucher_id)
);

create table tbl_vouchers_members
(
    voucher_member_id varchar(50) not null unique,
    voucher_id        varchar(50) not null,
    member_id         varchar(50) not null,

    foreign key (voucher_id)
        references tbl_vouchers (voucher_id)
        on delete cascade on update cascade,
    foreign key (member_id)
        references tbl_members (member_id)
        on delete cascade on update cascade
)
