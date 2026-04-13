import dayjs from "dayjs";
import type { Produto } from "../interfaces/Produto";
import databaseDelete from '../assets/skin/database_delete.png'
import { data } from "react-router-dom";

interface Props {
  produtos: Produto[];
}
//nome padrão Props

//th : Elemento do cabeçalho
//td: Dados
//emmet: div>table>thead>tr>th*8>tbody>td*8
// Button type reset: reseta as informações
//submit: envia uma requisição para o servidor -> formulário
//button: envia código javascript

//Recebe um objeto que contém um array de objetos, não o array diretamente.
//Referencia produtos
const TabelaDeProdutos = ({ produtos }: Props) => {
  return (
    <div>
      <table className="w-full border-2 border-green-600">
        <thead>
          <tr className="w-full border-2 border-green-600 bg-green-300">
            <th className="border-r border-r-green-200 p-1.5 font-semibold">
              Id
            </th>
            <th className="border-r border-r-green-200 p-1.5 font-semibold">
              Imagem
            </th>
            <th className="border-r border-r-green-200 p-1.5 font-semibold">
              Categoria
            </th>
            <th className="border-r border-r-green-200 p-1.5 font-semibold">
              Nome
            </th>
            <th className="border-r border-r-green-200 p-1.5 font-semibold">
              Disponível
            </th>
            <th className="border-r border-r-green-200 p-1.5 font-semibold">
              Data de Cadastro
            </th>
            <th className="border-r border-r-green-200 p-1.5 font-semibold">
              Preço
            </th>
            <th className="border-r border-r-green-200 p-1.5 font-semibold">
              Ação
            </th>
          </tr>
        </thead>
        <tbody>
          {produtos.map((produto, index) => (
            <tr
              className={
                "border  border-green-200 " +
                (index % 2 == 0 ? "bg-white" : "bg-green-100")
              }
            >
              <td className="w-[8%] border-r-green-200 py-1 text-center">
                {produto.id}
              </td>
              <td className="w-[10%] border-r-green-200 py-1 text-center">
                <div className="flex justify-center">
                  <img src={produto.imagem} width="40px" />
                </div>
              </td>
              <td className="w-[13%] border-r-green-200 py-1 ps-2">
                {produto.categoria.nome}
              </td>
              <td className="w-[20%] border-r-green-200 py-1 text-center">
                {produto.nome}
              </td>
              <td className="w-[13%] border-r-green-200 py-1 text-center">
                {produto.disponivel ? "Sim" : "Não"}
              </td>
              <td className="w-[13%] border-r-green-200 py-1 text-center">
                {dayjs(produto.dataCadastro).format("DD/MM/YYYY")}
              </td>
              <td className="w-[10%] border-r-green-200 py-1 pe-2 text-end">
                {produto.preco.toLocaleString("pt-br", {
                  minimumFractionDigits: 2,
                  maximumFractionDigits: 2,
                  useGrouping: true,
                })}
              </td>
              <td className="w-[13%] border-r border-r-green-200 py-1">
                <button className="btn-danger px-4 py-1" type="button">
                  <div className="flex items-center">
                  Remover
                  <img className="me-1" src={databaseDelete}/>
                  </div>
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    //<div>{produtos[0].nome}</div>
  );
};
export default TabelaDeProdutos;
//rafce react arrow fuction ...
