import 'dart:async';

// Stream<int>로 들어오는 숫자들을 모두 합산하는 함수
Future<int> sumStream(Stream<int> stream) async {
  var sum = 0;
  //Stream 안의 값을 하나씩 꺼내 비동기적으로 처리
  await for (var value in stream) {
    print('sumStream : $value');
    sum += value;
  }
  return sum;
}

// 1부터 to까지의 숫자를 Stream으로 하나씩 내보냄
// async*는 비동기 generator라는 의미로, yield를 통해 값을 하나씩 "흘려보낼 수" 있음
Stream<int> countStream(int to) async* {
  for (int i = 1; i <= to; i++) {
    print('countStream : $i');
    yield i;
  }
}

main() async {
  var stream = countStream(10);
  var sum = await sumStream(stream);
  print(sum); // 55
}
