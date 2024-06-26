package exam01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Ex03Test {

    @TempDir
    private File temDir;

    @Test
    void test1() {
        String path = temDir.getAbsolutePath();
        System.out.println(path);
    }

    @Test
    // @Timeout(3) // 3초 내에 수행이 되면 테스트 통과
    @Timeout(value=2500, unit= TimeUnit.MILLISECONDS) // 뒤에 나오는 초에 따라 시간변경됨
    void test2()throws Exception {
        Thread.sleep(2000);
    }
}

