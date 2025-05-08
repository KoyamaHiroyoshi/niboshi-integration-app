package jp.co.niboshi.interfaces.employees;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import jp.co.niboshi.domains.models.shared.tests.TestTarget;

/**
 * 従業員一覧取得API結合テスト
 */
@SpringBootTest
@AutoConfigureMockMvc
@Tag(TestTarget.INTEGRATION_TEST)
class GetEmployeesTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void 正常() throws Exception {
    // 実行
    mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    // TODO: レスポンスの確認
  }
}
