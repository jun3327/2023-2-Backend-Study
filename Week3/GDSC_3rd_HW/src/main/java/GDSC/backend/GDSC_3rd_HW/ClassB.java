package GDSC.backend.GDSC_3rd_HW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassB {
    private ClassA classA;

    @Autowired
    public ClassB(ClassA classA) {
        this.classA = classA;
    }
}
