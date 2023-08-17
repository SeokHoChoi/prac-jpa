CREATE TABLE IF NOT EXISTS `user` (
  `id` VARCHAR(36) NOT NULL,
  `username` VARCHAR(10) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

/*
     ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
     뭔지 모르겠음.

     계속 에러나서 GPT 이용함.
 */


# username 은 중복되면 안되니까 해줌.
# 그리고 리포지터리에서 로그인할때 어떤식으로 처리해줄지,
# username 과 password 만으로 user 를 찾아오는게 힘들어서 유니크키로 바꿈.
# username 과 password 를 엮어야했나?
# 근데 유니크키로 해도 findByUsername 이 안뜨네???? 내가 만들어주는거였던거 같기도함.
ALTER TABLE `user`
    ADD CONSTRAINT `uq_username` UNIQUE (`username`);