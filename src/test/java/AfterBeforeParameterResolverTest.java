import dev.hashnode.pragmaticcode.AfterBeforeParameterResolver;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@ExtendWith(AfterBeforeParameterResolver.class)
class AfterBeforeParameterResolverTest {

    private TestEnum capturedParameter;

    @BeforeEach
    public void init(TestEnum parameter) {
        capturedParameter = parameter;
    }

    @ParameterizedTest
    @EnumSource(TestEnum.class)
    public void test(TestEnum parameter) {
        Assertions.assertThat(parameter).isEqualTo(capturedParameter);
    }

    enum TestEnum {
        PARAMETER_1,
        PARAMETER_2
    }
}