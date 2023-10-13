package gdsc.backend.BootDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Jackson 역직렬화(Json To Object) 때문에 기본생성자 추가
//-->근데 분명 다른 스프링부트 프로젝트에서는 없어도 잘됐는데 지금은 왜 안되는지 모르겠다.. 버전문제인가
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DemoDto {
    private Long id;
    private String name;

}