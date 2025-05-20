import 'dart:convert';

var scores = [
  {'score': 40},
  {'score': 60},
  {'score': 80, 'overtime': true, 'special_guest': null}
];

void main() {
  var jsonText = jsonEncode(scores);
  print(jsonText ==
      '[{"score":40},{"score":60},{"score":80,"overtime":true,"special_guest":null}]');
  print(scores is List); // [] 는 List
  print(scores[0] is Map); // {} 는 Map
}
