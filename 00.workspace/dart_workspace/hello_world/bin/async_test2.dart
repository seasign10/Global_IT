main() async {
  var stream = Stream.fromIterable([1, 2, 3, 4, 5]); // List의 요소를 읽어올 수 있도록
  stream.first.then((value) => print("first : $value")); // 첫번째 요소를 읽어온다.
  stream.last.then((value) => print("last : $value")); // 마지막 요소를 읽어온다.
  stream.isEmpty.then((value) => print("isEmpty : $value")); // 비어있는지 확인한다.
  stream.length.then((value) => print("length : $value")); // 길이를 확인한다.
}
