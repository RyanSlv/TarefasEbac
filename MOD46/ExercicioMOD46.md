# Princípios do Código Limpo



Importância dos princípios

1. Nomenclatura adequada
---



Usar nomenclatura adequada significa escolher nomes claros e significativos para variáveis, métodos e classes. O nome deve representar a finalidade do elemento, permitindo que o leitor entenda o que ele faz ou armazena.



Por exemplo, uma variável chamada valorTotalCompra informa melhor seu significado do que uma variável chamada x.

Da mesma forma, calcularDesconto() descreve uma ação com mais clareza do que um método chamado executar().



Também é importante evitar abreviações difíceis de entender e manter um padrão de nomenclatura no projeto. Quando os nomes são consistentes, o código fica mais fácil de acompanhar.



Esse princípio facilita a leitura, reduz interpretações erradas e ajuda na manutenção. Além disso, diminui a necessidade de comentários que apenas expliquem a finalidade de um elemento.


#### 2\. Resolver os problemas na causa raiz



Resolver os problemas na causa raiz significa investigar e corrigir sua origem, em vez de apenas esconder os efeitos que aparecem durante a execução do sistema.



É como uma goteira: colocar um balde evita que a água se espalhe, mas não conserta o telhado. No desenvolvimento de software, uma solução improvisada pode esconder a falha temporariamente, sem impedir que ela volte a acontecer.



Por exemplo, se um sistema permite cadastrar o mesmo e-mail mais de uma vez, verificar sua existência antes do cadastro ajuda, mas pode não ser suficiente. Dois cadastros simultâneos podem realizar a verificação antes que qualquer um seja salvo.



Nesse caso, uma restrição de unicidade no banco de dados garante que o e-mail não seja duplicado, inclusive quando existem operações simultâneas. A aplicação também deve tratar a tentativa de duplicação e apresentar uma mensagem adequada.

Corrigir a causa raiz evita falhas recorrentes, reduz retrabalho e impede que o problema provoque erros em outras partes do sistema.



#### 3\. Política do escoteiro



A política do escoteiro orienta a deixar o código melhor do que foi encontrado. A ideia é realizar pequenas melhorias sempre que trabalhamos em uma parte do sistema.

Por exemplo, ao corrigir um erro, podemos melhorar o nome de uma variável, remover um trecho que não é mais utilizado ou simplificar uma condição difícil de entender.

Isso não significa reescrever todo o sistema a cada alteração. As melhorias devem estar relacionadas ao trabalho realizado e preservar o funcionamento esperado do código.



Quando essa prática é seguida continuamente, pequenos problemas de organização deixam de se acumular. O código se torna mais fácil de compreender, testar e modificar.



Esse princípio contribui para a manutenção do projeto ao longo do tempo e facilita o trabalho dos próximos desenvolvedores que precisarão lidar com aquele código.



#### Quais princípios os exemplos abaixo estão ferindo?



1. private void somaNumeros(int a, int b, int c, int d, int e, int f)

Essa assinatura apresenta os seguintes problemas:



* Poucos parâmetros: O método recebe seis argumentos, tornando sua utilização e seus testes mais trabalhosos. Métodos devem, sempre que possível, receber uma quantidade reduzida de parâmetros para facilitar sua compreensão. 



* Nomes significativos: Os parâmetros A, B, C, D, E e F não explicam o significado dos valores recebidos. Caso representem informações específicas, nomes mais descritivos facilitariam o entendimento do código.



2\. private void oPaiTaOn()



O método fere o princípio de nomenclatura adequada. Seu nome utiliza uma expressão informal que não esclarece qual operação será executada.



Um desenvolvedor que encontre essa assinatura precisará ler a implementação para entender sua finalidade. O nome deveria comunicar a ação realizada pelo método de forma clara e objetiva.



3\. private double checaSaldoEAtualiza(long userId, double value)



Considerando as operações indicadas pelo nome, o método apresenta os seguintes problemas:



* Fazer uma única coisa: O método combina a verificação do saldo com sua atualização. Reunir essas tarefas dificulta compreender e testar cada comportamento separadamente.



* Command-Query Separation (Separação entre Comandos e Consultas): Consultar o saldo fornece uma informação, enquanto atualizá-lo altera o estado do sistema. Misturar essas operações faz com que uma chamada de consulta também provoque uma alteração.



* Clareza da intenção: A assinatura não informa se o valor retornado representa o saldo anterior ou o saldo atualizado. Além disso, o parâmetro value não esclarece se corresponde a um valor de crédito, débito ou ao novo saldo.

