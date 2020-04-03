> 수정 날짜 (2020-04-03) / 작성 날짜 : (2020-03-28)

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

## 🤠 Serverless 에서 express 또는 koa 사용하기
serverless를 사용하다 보면 express 또는 koa를 사용하고 싶은 경우가 있다.

그럴 때는 [serverless-http](https://github.com/dougmoscrop/serverless-http) 를 사용하면 된다.

```js
// serverless-http 예제 코드

const serverless = require('serverless-http');
const Koa = require('koa'); // or any supported framework

const app = new Koa();

app.use(/* register your middleware as normal */);

// this is it!
module.exports.handler = serverless(app);

// or as a promise
const serverlessApp = serverless(app);
module.exports.handler = async (event, context) => {
  // you can do other things here
  const response = await serverlessApp(event, context);
  // and here
  return response;
};
```

```typescript
// serverless-http typescript 예제 코드
import serverless from 'serverless-http';
import { APIGatewayProxyHandler } from 'aws-lambda';

import app from './app';

const serverlessApp = serverless(app);

export const handler: APIGatewayProxyHandler = async(event, context) => {

  const response = await serverlessApp(event, context);
  try {
    await connection.close();
  } catch (e) {

  }

  return response;
};
```
