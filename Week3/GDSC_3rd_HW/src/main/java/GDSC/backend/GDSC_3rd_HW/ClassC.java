package GDSC.backend.GDSC_3rd_HW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassC {
    private ClassA classA;

    @Autowired
    public ClassC(ClassA classA) {
        this.classA = classA;
    }
}
