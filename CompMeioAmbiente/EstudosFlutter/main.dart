import 'dart:io';

void variaveis(){
  //////////////Declaração de variáveis
  
  String nome = "Amanda";
  int idade = 20;
  double valor = 105.5;
  bool isAdulto = true;
  const pi = 3.14; //não consegue mudar valor da const

  //se já tiver definido um tipo de valor não pode alterar:
  var dado; //lida com variável sem reservar o tipo


  dynamic dado2 = "dados";
  print(dado2);
  dado2 = 1000;
  print(dado2);
}

void entradaSaida(){
  String nome = "Amanda";
  int idade = 20;
  

  //Entrada e saída

  print("Hello, World!");
  print("Nome: " + nome); //não concatena com outros tipos de variáveis, somente string 
  print("Idade: " + idade.toString());
  //Para poder printar variáveis que não são string use $
  print("Nome $nome, Idade $idade");

  var nome2 = stdin.readLineSync();
  print(nome2);
}

void operadores(){
   //Operações aritméticos:
  int val1 = 100, val2 = 200;
  print("${val1 + val2}");
  print("${val1 - val2}");
  print("${val1 * val2}");
  print("${val1 / val2}");
  print("${val1 % val2}");


  //Operadores relacionais:
  print("${val1 == val2}");
  print("${val1 >= val2}");
  print("${val1 > val2}");
  print("${val1 <= val2}");
  print("${val1 < val2}");
  print("${val1 != val2}");

  //Operadores lógicos: (||, &&) e |, & bit a bit 

}

void operacoes(){
  int idade = 18;
  if (idade <= 10){
    print("Criança");
  }else if (idade > 10 && idade <= 18){
    print("Adolescente!");
  }else{
    print("Adulto");
  }

  String operacao = "somar";
  switch(operacao){
    case "somar":
      print(1  + 1);
      break;
    case "subtrair":
      print(1 - 1); 
      break;
    default:
      print("1");
  } 
  for (int i = 0; i < 5; i++){
    print(i);
  }

  int num = 5;
  while (num > 0){
    print(num);
    num--;
  }

  num = 0;
  do{
    print(num);
    num++;
  }while(num < 5);
}

//Parametros opcionais precisam ser os ultimos e estarem entre chaves 
void printData(String nome, int idade, {String? sobrenome, int teste = 10}){
  print("Dados -> Nome: $nome, Idade: $idade");
  print(sobrenome);
  print(teste);
}


void printData2(String nome,Function exibir, int idade){
  print("Dados -> Nome: $nome, Idade: $idade");
  exibir(idade);
}

void printAdulto(int idade){
  if (idade <= 10){
    print("Criança");
  }else if (idade > 10 && idade <= 18){
    print("Adolescente!");
  }else{
    print("Adulto");
  }
}

void verifyAdulto(int idade){
  if (idade <= 18){
    print("Menor de idade");
  }else{
    print("Adulto");
  }
}


void funcoes(){
  printData("Amanda", 20);
  printData2("Diogo",printAdulto, 22);
  printData2("Lais",verifyAdulto, 19);
  //Funções anonimas:
  int idade = 13;
  var func = (idade){
    if (idade <= 18){
      print("Menor de idade");
    }else{
      print("Adulto");
    }
  };
  func(idade);

  var func2 = (String nome) =>   print("Anonima -> Nome: $nome, Idade: $idade");

  func2("Juliana");

}


void colecoes(){
  //Coleções: lists e maps
  //Lists
  List<String> frutas = ["Maça", "Banana", "Abacaxi"];


  print(frutas);
  print(frutas[0]);

  List<int> nums = [1,2,3,4,5];
  print(nums);

  frutas.add("Morango");
  print(frutas);

  frutas.removeAt(2);
  print(frutas);
  print(frutas.contains("Morango"));
  for (String fruta in frutas){
    print(fruta);
  }
  //Maps (key,value )
  Map<String, String> estados = Map();
  estados["RJ"] = "Rio de Janeiro";
  estados["SP"] = "São Paulo";

  estados.forEach((key,value){
    print("Sigla $key, Nome $value");
  });
}
void main(){
  
  
  //variaveis();
  //entradaSaida();
  //operadores();
  //operacoes(); 
  //funcoes();
  //colecoes();
}