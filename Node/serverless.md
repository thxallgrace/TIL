> 작성 중 / 작성 날짜 : (2020-03-28)

# Serverless 사용법과 활용

### ⬇️ serverless 설치
```bash
npm install serverless -g
```
프로젝트를 만들고 싶으면 `serverless`를 입력해주면 된다.

### ➕ 플러그인
serverless에는 플러그인이 있는데 다양한 기능들을 추가로 사용할수 있다.  
주로 사용되는 플러그인은 `serverless-offline`, `serverless-plugin-typescript`이 있다.

#### serverless offline 사용법
`serverless offline start` 

### 🗞 기본 코드

```js
// any.js
const createResponse = (status, body) => ({
    statusCode: status,
    body: JSON.stringify(body),
});

exports.functionName = async event => {
  const body = JSON.parse(event.body);


  return createResponse(200, {
    hello: 'world',
    body: body,
  });
}
```

```yml
# serverless.yml
provider:
  name: aws
  runtime: nodejs12.x
  
  stage: prod
  region: ap-northeast-2 

  environment:
    TZ: Asia/Seoul

functions:
    functionName:
      handler: any.functionName
      events:
        - http: 
            path: /
            method: post

  
plugins:
  - serverless-offline
```

### ☄️ 배포
`serverless deploy` 