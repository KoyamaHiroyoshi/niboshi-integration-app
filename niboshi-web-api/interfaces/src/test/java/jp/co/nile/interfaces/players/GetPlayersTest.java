package jp.co.nile.interfaces.players;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import jp.co.nile.domains.models.shared.tests.TestTarget;

/**
 * プレイヤー一覧取得API結合テスト
 */
@SpringBootTest
@AutoConfigureMockMvc
@Tag(TestTarget.INTEGRATION_TEST)
class GetPlayersTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void 正常() throws Exception {
    // 実行
    mockMvc.perform(MockMvcRequestBuilders.get("/players"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    // TODO: レスポンスの確認
  }
}
