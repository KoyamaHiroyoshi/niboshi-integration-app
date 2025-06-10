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
  question11 VARCHAR(1) NOT NULL,
  question12 VARCHAR(1) NOT NULL,
  question13 VARCHAR(1) NOT NULL,
  question14 VARCHAR(1) NOT NULL,
  question15 VARCHAR(1) NOT NULL,
  question16 VARCHAR(1) NOT NULL,
  question17 VARCHAR(1) NOT NULL,
  question18 VARCHAR(1) NOT NULL,
  question19 VARCHAR(1) NOT NULL,
  question20 VARCHAR(1) NOT NULL,
  question21 VARCHAR(1) NOT NULL,
  question22 VARCHAR(1) NOT NULL,
  question23 VARCHAR(1) NOT NULL,
  question24 VARCHAR(1) NOT NULL,
  question25 VARCHAR(1) NOT NULL,
  question26 VARCHAR(1) NOT NULL,
  question27 VARCHAR(1) NOT NULL,
  question28 VARCHAR(1) NOT NULL,
  question29 VARCHAR(1) NOT NULL,
  question30 VARCHAR(1) NOT NULL,
  question31 VARCHAR(1) NOT NULL,
  question32 VARCHAR(1) NOT NULL,
  question33 VARCHAR(1) NOT NULL,
  question34 VARCHAR(1) NOT NULL,
  question35 VARCHAR(1) NOT NULL,
  question36 VARCHAR(1) NOT NULL,
  question37 VARCHAR(1) NOT NULL,
  question38 VARCHAR(1) NOT NULL,
  question39 VARCHAR(1) NOT NULL,
  question40 VARCHAR(1) NOT NULL,
  question41 VARCHAR(1) NOT NULL,
  question42 VARCHAR(1) NOT NULL,
  question43 VARCHAR(1) NOT NULL,
  question44 VARCHAR(1) NOT NULL,
  question45 VARCHAR(1) NOT NULL,
  question46 VARCHAR(1) NOT NULL,
  question47 VARCHAR(1) NOT NULL,
  question48 VARCHAR(1) NOT NULL,
  question49 VARCHAR(1) NOT NULL,
  question50 VARCHAR(1) NOT NULL,
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
COMMENT ON COLUMN self_evaluation.question11 IS '設問11';
COMMENT ON COLUMN self_evaluation.question12 IS '設問12';
COMMENT ON COLUMN self_evaluation.question13 IS '設問13';
COMMENT ON COLUMN self_evaluation.question14 IS '設問14';
COMMENT ON COLUMN self_evaluation.question15 IS '設問15';
COMMENT ON COLUMN self_evaluation.question16 IS '設問16';
COMMENT ON COLUMN self_evaluation.question17 IS '設問17';
COMMENT ON COLUMN self_evaluation.question18 IS '設問18';
COMMENT ON COLUMN self_evaluation.question19 IS '設問19';
COMMENT ON COLUMN self_evaluation.question20 IS '設問20';
COMMENT ON COLUMN self_evaluation.question21 IS '設問21';
COMMENT ON COLUMN self_evaluation.question22 IS '設問22';
COMMENT ON COLUMN self_evaluation.question23 IS '設問23';
COMMENT ON COLUMN self_evaluation.question24 IS '設問24';
COMMENT ON COLUMN self_evaluation.question25 IS '設問25';
COMMENT ON COLUMN self_evaluation.question26 IS '設問26';
COMMENT ON COLUMN self_evaluation.question27 IS '設問27';
COMMENT ON COLUMN self_evaluation.question28 IS '設問28';
COMMENT ON COLUMN self_evaluation.question29 IS '設問29';
COMMENT ON COLUMN self_evaluation.question30 IS '設問30';
COMMENT ON COLUMN self_evaluation.question31 IS '設問31';
COMMENT ON COLUMN self_evaluation.question32 IS '設問32';
COMMENT ON COLUMN self_evaluation.question33 IS '設問33';
COMMENT ON COLUMN self_evaluation.question34 IS '設問34';
COMMENT ON COLUMN self_evaluation.question35 IS '設問35';
COMMENT ON COLUMN self_evaluation.question36 IS '設問36';
COMMENT ON COLUMN self_evaluation.question37 IS '設問37';
COMMENT ON COLUMN self_evaluation.question38 IS '設問38';
COMMENT ON COLUMN self_evaluation.question39 IS '設問39';
COMMENT ON COLUMN self_evaluation.question40 IS '設問40';
COMMENT ON COLUMN self_evaluation.question41 IS '設問41';
COMMENT ON COLUMN self_evaluation.question42 IS '設問42';
COMMENT ON COLUMN self_evaluation.question43 IS '設問43';
COMMENT ON COLUMN self_evaluation.question44 IS '設問44';
COMMENT ON COLUMN self_evaluation.question45 IS '設問45';
COMMENT ON COLUMN self_evaluation.question46 IS '設問46';
COMMENT ON COLUMN self_evaluation.question47 IS '設問47';
COMMENT ON COLUMN self_evaluation.question48 IS '設問48';
COMMENT ON COLUMN self_evaluation.question49 IS '設問49';
COMMENT ON COLUMN self_evaluation.question50 IS '設問50';
COMMENT ON COLUMN self_evaluation.created_at IS '登録日時';
COMMENT ON COLUMN self_evaluation.updated_at IS '更新日時';

INSERT INTO public.self_evaluation( id, user_id, question01, question02, question03, question04, question05, question06, question07, question08, question09, question10, question11, question12, question13, question14, question15, question16, question17, question18, question19, question20, question21, question22, question23, question24, question25, question26, question27, question28, question29, question30, question31, question32, question33, question34, question35, question36, question37, question38, question39, question40, question41, question42, question43, question44, question45, question46, question47, question48, question49, question50) 
  VALUES 
  ( '100000000001', 'NBS_100001', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO public.self_evaluation( id, user_id, question01, question02, question03, question04, question05, question06, question07, question08, question09, question10, question11, question12, question13, question14, question15, question16, question17, question18, question19, question20, question21, question22, question23, question24, question25, question26, question27, question28, question29, question30, question31, question32, question33, question34, question35, question36, question37, question38, question39, question40, question41, question42, question43, question44, question45, question46, question47, question48, question49, question50) 
  VALUES 
  ( '100000000002', 'NBS_100002', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
