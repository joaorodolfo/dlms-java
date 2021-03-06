package daelim.lnl.dlms.web;

import daelim.lnl.dlms.service.posts.LockersService;
import daelim.lnl.dlms.web.dto.LockersResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class LockersApiController {

    private final LockersService lockersService;

//    @PostMapping("/api/v1/lockers")
//    public Long save(@RequestBody lockersSaveRequestDto requestDto){
//        return lockersService.save(requestDto);
//    }

//    @DeleteMapping("/api/v1/lockers/{id}")
//    public Long delete(@PathVariable Long id){
//        lockersService.delete(id);
//        return id;
//    }

    @GetMapping("/api/v1/lksearch/{idx}")
    public LockersResponseDto findByIdx(@PathVariable Long idx) {
        return lockersService.findByIdx(idx);
    }

    @GetMapping("/api/v1/lockers/{position}")
    public void update(@PathVariable String position, HttpServletResponse response) throws IOException {
            lockersService.updateStatus(position);

            response.sendRedirect("/u_complete");
    }
}