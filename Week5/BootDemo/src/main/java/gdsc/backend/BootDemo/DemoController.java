package gdsc.backend.BootDemo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    //객체 리스트 반환
    @GetMapping("/demoEntities")
    public ResponseEntity<List<DemoDto>> getDemoEntities() {
        return ResponseEntity.ok().body(demoService.getDemoEntities());
    }

    //객체 추가
    @PostMapping("/demoEntities")
    public void getDemoEntities(@RequestBody DemoDto demoDto) {
        demoService.addDemoEntity(demoDto);
    }

    //id로 객체 조회
    @GetMapping("/demoEntities/{id}")
    public ResponseEntity<DemoDto> getDemoEntity(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(demoService.getDemoEntityById(id));
    }
}
