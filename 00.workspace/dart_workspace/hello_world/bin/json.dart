import 'dart:convert';

void main() {
  var jasonString = '''
  [
    {"score": 40},
    {"score": 60}
  ]
  ''';

  var scores = jsonDecode(jasonString); // json으로 인코딩
  print(scores is List);
  var firstScore = scores[0];
  print(firstScore is Map);
  print(firstScore['score'] == 40);
}
