package GDSC.backend.GDSC_4th_HW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;
    private C c;

    @Autowired
    public A(B b, C c) {
        this.b = b;
        this.c = c;
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }
}
