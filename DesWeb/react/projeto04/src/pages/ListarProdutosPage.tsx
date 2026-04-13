import { useEffect, useState } from "react";
import TabelaDeProdutos from "../component/TabelaDeProdutos";
//import recuperarProdutos from "../util/recuperarProdutos"

const ListarProdutosPage = () => {
  //const produtos = recuperarProdutos();

  /*
  const numeros: number = [1,2,3];
  console.log(numeros[0]);

  const [um, dois, tres]: number[] = [1,2,3]; //destructure do array
  console.log(um)*/

  //dar um nome para o que você quer e chama o set
  const [produtos, setProdutos] = useState([]);
  const [erro, setErro] = useState(""); //Variável de estado

  useEffect(() => {
    fetch("http://localhost:8080/produtos") //fetch envia requisição http para o back-end, quando o back-end responder, a função then é executada e recebe um objeto response
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            "Ocorreu um erro ao recuperar produtos. Status: " + response.status,
          );
        }
        return response.json(); //converte a resposta json do response para um array de objetos do tipo produto
      })
      .then((produtos) => {
        setProdutos(produtos);
      })
      .catch((error) => {
        if (error instanceof Error) {
          setErro(error.message);
        } else {
          setErro("Ocorreu um erro desconhecido!" + error);
        }
      });
  }, []);

  // "" em javascript é avaliado para falsy
  if (erro) return <p className="text-lg">{erro}</p>;
  if (produtos.length == 0)
    return <p className="text-lg">Recuperando produtos...</p>;

  return (
    <>
      <h1 className="font semibold mb-1 text-xl">Lista de Produtos</h1>
      <hr className="mb-4" />
      <TabelaDeProdutos produtos={produtos} />
    </>
  );
};
export default ListarProdutosPage;
