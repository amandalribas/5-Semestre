import type { Produto } from "../interfaces/Produto";

interface Props {
    produtos: Produto[];
}
//nome padrão Props


//Recebe um objeto que contém um array de objetos, não o array diretamente.
//Referencia produtos 
const TabelaDeProdutos = ({produtos}: Props) => {
  return (
    <div>{produtos[0].nome}</div>
  )
}
export default TabelaDeProdutos
//rafce react arrow fuction ...