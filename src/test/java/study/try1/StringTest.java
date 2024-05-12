package study.try1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    void splitTest() {
        String param = "1,2";

        assertThat(param.split(","))
                .containsExactly("1", "2");
    }

    @Test
    void splitSingleTest() {
        String param = "1";

        assertThat(param.split(","))
                .containsExactly("1");
    }

    @Test
    void substringWithoutBracket() {
        String param = "(1,2)";

        assertThat(param.substring(1, param.length() - 1))
                .isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAtTest(int index, char value) {
        String param = "abc";

        assertThat(param.charAt(index)).isEqualTo(value);
    }

    @DisplayName("charAt 사용 시 인덱스를 벗어나면 StringIndexOutOfBoundsException을 던진다.")
    @Test
    void charAtExceptionTest() {
        String param = "abc";

        assertThatThrownBy(() -> param.charAt(param.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
