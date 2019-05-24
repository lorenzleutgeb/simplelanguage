function main() {
  x = readln();
  if (x == "tainted") {
    y = sanitize(x) + " ... not anymore";
    println(y);
  }
}
