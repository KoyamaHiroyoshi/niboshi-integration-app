set search_path to "public";

-- self_evaluation

CREATE TABLE IF NOT EXISTS self_evaluation (
  id VARCHAR(12) PRIMARY KEY,
  user_id VARCHAR(12) NOT NULL,
  question01 VARCHAR(1) NOT NULL,
  question02 VARCHAR(1) NOT NULL,
  question03 VARCHAR(1) NOT NULL,
  question04 VARCHAR(1) NOT NULL,
  question05 VARCHAR(1) NOT NULL,
  question06 VARCHAR(1) NOT NULL,
  question07 VARCHAR(1) NOT NULL,
  question08 VARCHAR(1) NOT NULL,
  question09 VARCHAR(1) NOT NULL,
  question10 VARCHAR(1) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE self_evaluation IS '自己評価テーブル';
COMMENT ON COLUMN self_evaluation.id IS 'ID';
COMMENT ON COLUMN self_evaluation.user_id IS '従業員ID';
COMMENT ON COLUMN self_evaluation.question01 IS '設問1';
COMMENT ON COLUMN self_evaluation.question02 IS '設問2';
COMMENT ON COLUMN self_evaluation.question03 IS '設問3';
COMMENT ON COLUMN self_evaluation.question04 IS '設問4';
COMMENT ON COLUMN self_evaluation.question05 IS '設問5';
COMMENT ON COLUMN self_evaluation.question06 IS '設問6';
COMMENT ON COLUMN self_evaluation.question07 IS '設問7';
COMMENT ON COLUMN self_evaluation.question08 IS '設問8';
COMMENT ON COLUMN self_evaluation.question09 IS '設問9';
COMMENT ON COLUMN self_evaluation.question10 IS '設問10';
COMMENT ON COLUMN self_evaluation.created_at IS '登録日時';
COMMENT ON COLUMN self_evaluation.updated_at IS '更新日時';

INSERT INTO self_evaluation (id, user_id, question01, question02, question03, question04, question05, question06, question07, question08, question09, question10)
  VALUES
  ('100000000001', 'NBS_100001', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' );
INSERT INTO self_evaluation (id, user_id, question01, question02, question03, question04, question05, question06, question07, question08, question09, question10)
  VALUES
  ('100000000002', 'NBS_100001', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' );
