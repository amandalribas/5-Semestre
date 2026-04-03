abstract class Animal{
  String? cor; //? aceita null

  //Não permite criar multimos construtores sem nome
  /*
  Animal(String cor){
    this.cor = cor;
  }*/

  Animal(){

  }

  //Construtor nomeado:
  Animal.cor(this.cor);

  Animal.cavalo(this.cor){
    print("Construtor cavalo!");
  }
  void dormir(){
    print("Dormir!");
  }

  void correr(){
    print("Correr como um");
  }
}

//A super classe precisa ter construtor vazio class Gato extends Animal{
class Gato extends Animal{
  String corFucinho = "";

  void miar(){
    print("Miar");
  }
  Gato(String cor, this.corFucinho) : super.cor(cor);

  @override
  void correr(){
    super.correr();
    print("Gato!");
  }
}


class Passaro extends Animal {
  String corBico = "";

  Passaro(String cor, this.corBico) : super.cor(cor);
  
  void voar(){
    print("Voar!");
  }

  @override
  void correr(){
    super.correr();
    print("Passaro!");
  }
}


class Conta{
  //atributos iniciados com _ são privados 
    double _saque = 0.0; 

    double get saque{
      return this._saque;
    }

    set saque(double saque){
      if (saque > 0 && saque <= 500){
        this._saque = saque;
      }
    }
  
  
  }


class Config{
  static String appId = "12345abc";
  final String deviceId = "androidId"; //não consegue alterar 

  static void init(){
    print("Iniciando as configurações");
  }
}

class Pessoa{
  String nome = "";
  int idade = 0;

  void comer(){
    print("Comer!");
  }
}

abstract class Aluno{
  void estudar(){
  }
}

abstract class Professor{
  void ensinar(){

  }
}


class Amanda extends Pessoa implements Aluno{
  @override
  void estudar(){
    print("Estudar");
  }

}

class Leandro extends Pessoa implements Professor{
  @override
  void ensinar(){
    print("Ensinando");
  }
}

void main(){

  //Inicialização sem Construtor:
  /*

  Animal animal1 = new Animal();
  animal1.cor = "Azul";
  animal1.dormir();
  print(animal1.cor);
  Animal animal2 = Animal(); //o new é opcional
  animal2.cor = "Branco";
  animal2.dormir();
  
  print("Animal 1: ${animal1.cor}, Animal 2: ${animal2.cor}");
  */

  //Inicialização com Construtor:
  /*
  Animal animal1 = new Animal("Azul");
  Animal animal2 = new Animal("Verde");
  print("Animal 1: ${animal1.cor}, Animal 2: ${animal2.cor}");

  Animal animal3 = new Animal.cavalo("Marrom");
  print("Construtor nomeado: ${animal3.cor}");
  */

  //Herança:
  
  Gato gato = Gato("Marrom", "Branco");
  gato.dormir();
  gato.miar();
  
  print("Gato: cor= ${gato.cor}, cor fucinho= ${gato.corFucinho}");


  Passaro passaro = Passaro("Vermelho", "Rosa");
  passaro.dormir();
  passaro.voar();

  print("Passaro: cor=${passaro.cor}, cor bico=${passaro.corBico}");
  

  //Getter e Setters:
  /*
  Conta conta = Conta();
  //Chamam o get e set automaticamente:
  conta.saque = 100;
  print("Conta -> saque=${conta.saque}");

  conta._saque = 1000; 
  print("Conta -> saque=${conta.saque}");
  */
  
  //Sobrescrita de métodos 
  //animal1.correr();
  gato.correr();
  passaro.correr();
  
  //Classes abstratas

  //Modificadores static e final
  Config config = Config(); //Heap e pilha
  //print(config.appId);
  print(Config.appId);
  Config.init();
  print(config.deviceId);
  //config.deviceId = "ios123";
  //print(config.deviceId);

  //Interface -- não tem suporte a herança de múltiplas classes 
  Amanda amanda = Amanda();
  amanda.estudar();

  Leandro leandro = Leandro();
  leandro.ensinar();

}