# telco

## Projeto

O projeto **Telco** está sendo desenvolvido para apoiar as operações de uma empresa de telefonia, que oferece serviços móveis e residenciais. 

O sistema apoia a criação e adesão de novos usuários, agendamento de instalações residenciais e acompanhamento do suporte técnico em tempo real.

### Entidades importantes:
- Customer

### Requisitos não funcionais:
- Escalabilidade
- Disponibilidade
- Tolerância a falhas

### Ref. MAX_POLL_RECORDS_CONFIG:
- Qual é o valor default desse configuração?
Valor default: 500

- Porque esse valor poderia não ser adequado?
Porque o método poll consumiria os 500 records (registros) e caso 1 ocorra erro (exception), teríamos que fazer alguma regra para tratamento deste erro ou então perderia o registro.

- Como acontece a confirmação de que uma mensagem foi consumida?
Através do método poll.

### Ref. consumir mensagens antigas:
Coloquei a seguinte configuração para consumir mensagens antigas (porém não funcionou):
properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

Para novas mensagens:
properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");