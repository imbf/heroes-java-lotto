package lotto;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void valueOfTest() {
        assertThat(Rank.valueOf(3,true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2,true)).isEqualTo(null);
        assertThat(Rank.valueOf(6,false)).isEqualTo(Rank.FIRST);
    }
}
