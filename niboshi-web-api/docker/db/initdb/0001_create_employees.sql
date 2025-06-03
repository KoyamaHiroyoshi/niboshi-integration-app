set search_path to "public";

-- employees

CREATE TABLE IF NOT EXISTS employees (
  id VARCHAR(12) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  mail_address VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE employees IS '従業員テーブル';
COMMENT ON COLUMN employees.id IS '従業員ID';
COMMENT ON COLUMN employees.name IS '従業員名';
COMMENT ON COLUMN employees.mail_address IS 'メールアドレス';
COMMENT ON COLUMN employees.created_at IS '登録日時';
COMMENT ON COLUMN employees.updated_at IS '更新日時';

INSERT INTO employees (id, name, mail_address)
  VALUES
  ('NBS_100001', 'テスト従業員1', 'aaaaaaaaaa@yahoo.co.jp');
INSERT INTO employees (id, name, mail_address)
  VALUES
  ('NBS_100002', 'テスト従業員2', 'abbbbbbbbb@yahoo.co.jp');
