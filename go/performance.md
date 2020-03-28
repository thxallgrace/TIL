> 작성 중 / 작성 날짜 : (2020-03-24)

# Go언어 성능 & 속도 최적화 방법

### 🐌 fmt는 느리다.

#### 출력
출력할때 20 ~ 30개 미만일때는 fmt.Println이 더 빠르지만  
20~30개이상일떄는 bufio를 이용하는게 휠씬 더 빠르다

```go
writer := bufio.NewWriter(os.Stdout)

for i := 0; i < 100; i++ {
  fmt.Fprintln(writer, "hello world")
}

writer.Flush()

// 21 ns/나노초

for i := 0; i < 100; i++ {
  fmt.Println("hello world")
}
// 100ns/나노초
```

#### 입력
이건 벤치마킹할수 없어서 못했긴 한데 bufio를 사용하는게 더 빠르다고 한다

```go
reader := bufio.NewReader(os.Stdin)

var length int

fmt.Fscanln(reader, &length)
```