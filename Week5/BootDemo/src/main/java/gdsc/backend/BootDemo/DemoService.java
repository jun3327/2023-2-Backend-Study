package gdsc.backend.BootDemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DemoService {

    private final List<DemoEntity> demoEntities = new ArrayList<>(Arrays.asList(
            new DemoEntity(1L, "1번"),
            new DemoEntity(2L, "2번"),
            new DemoEntity(3L, "3번")
    ));

    //객체리스트 반환
    public List<DemoDto> getDemoEntities() {
        List<DemoDto> demoDtos = new ArrayList<>();
        for (DemoEntity demoEntity : demoEntities) {
            demoDtos.add(new DemoDto(demoEntity.getId(), demoEntity.getName()));
        }
        return demoDtos;
    }

    //객체 추가
    public void addDemoEntity(DemoDto demoDto) {
        demoEntities.add(new DemoEntity(demoDto.getId(), demoDto.getName()));
    }

    //id로 객체 조회
    public DemoDto getDemoEntityById(Long id) {
        for (DemoEntity demoEntity : demoEntities) {
            if (demoEntity.getId().equals(id)) {
                return new DemoDto(demoEntity.getId(), demoEntity.getName());
            }
        }
        throw new IllegalArgumentException("해당하는 id가 없음");
    }
}

