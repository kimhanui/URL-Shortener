URL-Shortener
---
![image](https://user-images.githubusercontent.com/30483337/140315628-e31d5929-d545-4c31-be3c-f8915f84e0b4.PNG)

## 주제 
긴 url을 짧은 url로 변환해주는 서비스 구현
> bit.ly같은 서비스? 맞다

## 요구사항  
- [x] 웹 페이지 입력폼에 URL 입력 시 단축된 결과 출력  => [Issue #4](https://github.com/kimhanui/URL-Shortener/issues/4)

- [x] 브라우저의 주소창에 단축 URL 입력 시 기존 URL로 리다이렉트 => [Issue #5](https://github.com/kimhanui/URL-Shortener/issues/5)

- [x] 같은 URL 입력 시 동일한 결과값 도출 => [Issue #4](https://github.com/kimhanui/URL-Shortener/issues/4)

- [x] 결과값은 주소를 제외하고 8글자 이내로 생성 => [Issue #8](https://github.com/kimhanui/URL-Shortener/issues/8)

## 고민한 내용
- [Issue #6](https://github.com/kimhanui/URL-Shortener/issues/6): 새 url 새성 메커니즘(Algorithm vs DB)
- [Issue #7](https://github.com/kimhanui/URL-Shortener/issues/7): url의 어느부분까지 줄여야하는가
- [Issue #8](https://github.com/kimhanui/URL-Shortener/issues/8): 결과값은 주소를 제외하고 8글자 이내로 생성

## 예외 처리
- 이미 변환된 url을 다시 변환하려고 하면 예외 발생
- 내 서비스에서 변환하지 않은 url에서 원래 url을 찾으려고 하면 예외 발샘

