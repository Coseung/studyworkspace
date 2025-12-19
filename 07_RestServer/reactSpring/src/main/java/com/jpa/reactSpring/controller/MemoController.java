package com.jpa.reactSpring.controller;

import com.jpa.reactSpring.dto.MemoDto;
import com.jpa.reactSpring.entity.Memo;
import com.jpa.reactSpring.service.MemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://localhost:5173") // 프론트엔드 포트 열어주기, 이거 안하면 CORS 에러남
@RestController
@RequestMapping("/api/memos")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;
    @GetMapping
    public ResponseEntity<List<Memo>> getMemos(@RequestParam Long memberId) {

        return ResponseEntity.ok(memoService.getMemos(memberId));
    }


    @PostMapping
    public ResponseEntity<Memo> addMemo(@RequestBody MemoDto.MemoRequestDto dto ) {
        return ResponseEntity.ok(memoService.addMemo(dto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Memo> updateMemo(@PathVariable Long id,
                                           @RequestParam Long memberId,
                                           @RequestBody Map<String, String> body) {
        String memoText = body.get("memo");
        return ResponseEntity.ok(memoService.updateMemo(id, memoText, memberId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable Long id, @RequestParam Long memberId) {
        memoService.deleteMemo(id, memberId);
        return ResponseEntity.ok("삭제 성공");
    }


//    @GetMapping("/push/{pushId}")
//    public ResponseEntity<List<Memo>> getMemosByPushId(@PathVariable String pushId,
//                                                       @RequestParam Long memberId) {
//        return ResponseEntity.ok(memoService.getMemosByPushId(pushId, memberId));
//    }
}