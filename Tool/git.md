> 작성 중 / 작성 날짜 : (2020-03-24)

# Git 명령어 및 사용방법 공부

###  현재 폴더에 깃 설정하기

**클론을 받은 경우에는 필요하지않음!**  
```git init``` 을 통해서 현재 폴더를 깃 폴더로 설정해 깃 명령어가 사용 가능하다.

`git remote add origin https://github.com/cjaewon/thisisgithub.git`  
을 통하여 연결한다.

### 🔃 최신 소스코드로 업데이트

`git pull origin master` 을 통하여 최신 코드로 업데이트 할 수 있다.
강제로 최신 소스코드로 업데이트 하고 싶다면 이것도 `-f` flag를 붙여주면 된다. 

`git fetch` - 추가 예정

### ⬆️ 깃허브에 올리기

`git add .` - 깃이 파일들을 추척한다 ( ex 수정된 파일, 삭제된 파일, 새로 생긴 파일 등  )   
만약 강제로 할려면 `-f` flag를 붙혀주면 된다

`git commit -m "Message"` - 변경상황을 내 컴퓨터에 저장한다  
만약 실수로 커밋했다면 수정 후에--amend flag 를 붙여주면 된다.

`git push origin master` - 깃허브에 업로드한다.

### ➕ 파일 병합

`git merge`  
`git remote`

### 😞 깃무시 ? .gitignore

git이 자동으로 추가할 필요가 없는 폴더, 파일이 있다  
이럴때에는 `.gitignore` 에 추가하면 된다.
