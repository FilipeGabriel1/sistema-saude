package co.projeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import co.projeto.Entidades.Consulta;
import co.projeto.Entidades.Exame;
import co.projeto.Entidades.Medico;
import co.projeto.Entidades.Paciente;
import co.projeto.Entidades.Recepcionista;
import co.projeto.Repositorio.RepositorioConsulta;
import co.projeto.Repositorio.RepositorioExame;
import co.projeto.Repositorio.RepositorioMedico;
import co.projeto.Repositorio.RepositorioPaciente;
import co.projeto.Repositorio.RepositorioRecepcionista;

public class Main {

     public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de acesso:");
        System.out.println("1 - Administrador");
        System.out.println("2 - Médico");
        System.out.println("3 - Recepcionista");
        System.out.println("4 - Paciente");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        if (opcao == 1) {
            System.out.print("Digite a senha de administrador: ");
            String senha = scanner.nextLine();

            if (senha.isEmpty()) {
                System.out.println("Preencha todos os campos obrigatorios");
                return;
            }

            if (senha.equals("admin123")) {
                System.out.println("\nBem-vindo ao sistema, Administrador!");

                RepositorioMedico repositorioMedico = new RepositorioMedico();
                RepositorioRecepcionista repositorioRecepcionista = new RepositorioRecepcionista();
                RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
                RepositorioConsulta repositorioConsulta = new RepositorioConsulta();
                RepositorioExame repositorioExame = new RepositorioExame();

                while (true) {
                    System.out.println("\nO que deseja gerenciar?");
                    System.out.println("1 - Médicos");
                    System.out.println("2 - Recepcionistas");
                    System.out.println("3 - Pacientes");
                    System.out.println("4 - Consultas");
                    System.out.println("5 - Exames");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opção: ");
                    int entidade = scanner.nextInt();
                    scanner.nextLine();

                    if (entidade == 0) {
                        System.out.println("Saindo do menu administrador.");
                        break;
                    }

                    if (entidade == 1) {
                        while (true) {
                            System.out.println("\nGerenciamento de Médicos:");
                            System.out.println("1 - Cadastrar Médico");
                            System.out.println("2 - Listar Todos os Médicos");
                            System.out.println("3 - Buscar Médico por CRM");
                            System.out.println("4 - Editar Médico");
                            System.out.println("5 - Remover Médico");
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha uma opção: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha == 0) break;

                            if (escolha == 1) {
                                System.out.print("CRM: ");
                                int crm = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
                                System.out.print("Telefone: ");
                                String telefone = scanner.nextLine();
                                System.out.print("Email: ");
                                String email = scanner.nextLine();
                                System.out.print("Senha: ");
                                String senhaMedico = scanner.nextLine();
                                System.out.print("Especialidade: ");
                                String especialidade = scanner.nextLine();

                                boolean camposVazios = nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() ||
                                                       email.isEmpty() || senhaMedico.isEmpty() || especialidade.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios para continuar");
                                    continue;
                                }

                                Medico medico = new Medico(crm, nome, cpf, telefone, email, senhaMedico, especialidade);
                                repositorioMedico.addMedico(medico);
                                System.out.println("Médico cadastrado com sucesso!");
                            } else if (escolha == 2) {
                                ArrayList<Medico> medicos = repositorioMedico.listarMedicos();
                                for (int i = 0; i < medicos.size(); i++) {
                                    System.out.println(medicos.get(i));
                                }
                            } else if (escolha == 3) {
                                System.out.print("Digite o CRM do médico: ");
                                int crmBusca = scanner.nextInt();
                                scanner.nextLine();
                                Medico medico = repositorioMedico.buscarMedicoPorCrm(crmBusca);
                                if (medico != null) {
                                    System.out.println(medico);
                                } else {
                                    System.out.println("Médico não encontrado.");
                                }
                            } else if (escolha == 4) {
                                System.out.print("Digite o CRM do médico a editar: ");
                                int crmEdit = scanner.nextInt();
                                scanner.nextLine();
                                Medico medico = repositorioMedico.buscarMedicoPorCrm(crmEdit);
                                if (medico != null) {
                                    System.out.print("Novo nome: ");
                                    String nome = scanner.nextLine();
                                    System.out.print("Novo CPF: ");
                                    String cpf = scanner.nextLine();
                                    System.out.print("Novo telefone: ");
                                    String telefone = scanner.nextLine();
                                    System.out.print("Novo email: ");
                                    String email = scanner.nextLine();
                                    System.out.print("Nova senha: ");
                                    String senhaMedico = scanner.nextLine();
                                    System.out.print("Nova especialidade: ");
                                    String especialidade = scanner.nextLine();
                            
                                    boolean camposVazios = nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() ||
                                                           email.isEmpty() || senhaMedico.isEmpty() || especialidade.isEmpty();

                                    if (camposVazios) {
                                        System.out.println("Preencha todos os campos obrigatorios para continuar");
                                        continue;
                                    }

                                    Medico medicoEditado = new Medico(crmEdit, nome, cpf, telefone, email, senhaMedico, especialidade);
                                    repositorioMedico.editarMedico(medicoEditado);
                                    System.out.println("Medico atualizado com sucesso");
                                } else {
                                    System.out.println("Médico não encontrado.");
                                }
                            } else if (escolha == 5) {
                                System.out.print("Digite o CRM do médico a remover: ");
                                int crmRemove = scanner.nextInt();
                                scanner.nextLine();
                                Medico medico = repositorioMedico.buscarMedicoPorCrm(crmRemove);
                                if (medico != null) {
                                    repositorioMedico.removerMedico(medico);
                                    System.out.println("Médico removido com sucesso!");
                                } else {
                                    System.out.println("Médico não encontrado.");
                                }
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        }
                    } else if (entidade == 2) {
                        while (true) {
                            System.out.println("\nGerenciamento de Recepcionistas:");
                            System.out.println("1 - Cadastrar Recepcionista");
                            System.out.println("2 - Listar Todos os Recepcionistas");
                            System.out.println("3 - Buscar Recepcionista por ID");
                            System.out.println("4 - Editar Recepcionista");
                            System.out.println("5 - Remover Recepcionista");
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha uma opção: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha == 0) break;

                            if (escolha == 1) {
                                System.out.print("ID: ");
                                int pacienteIdNovo = scanner.nextInt(); // Renomeado para pacienteIdNovo
                                scanner.nextLine();
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
                                System.out.print("Telefone: ");
                                String telefone = scanner.nextLine();
                                System.out.print("Email: ");
                                String email = scanner.nextLine();
                                System.out.print("Senha: ");
                                String senhaRecep = scanner.nextLine();
                                System.out.print("Turno: ");
                                String turno = scanner.nextLine();

                                boolean camposVazios = nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() ||
                                                       email.isEmpty() || senhaRecep.isEmpty() || turno.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios para continuar");
                                    continue;
                                }

                                Recepcionista recepcionista = new Recepcionista(pacienteIdNovo, nome, cpf, telefone, email, senhaRecep, turno);
                                repositorioRecepcionista.addRecepcionista(recepcionista);
                                System.out.println("Recepcionista cadastrado com sucesso!");
                            } else if (escolha == 2) {
                                ArrayList<Recepcionista> recepcionistas = repositorioRecepcionista.listarRecepcionistas();
                                for (int i = 0; i < recepcionistas.size(); i++) {
                                    System.out.println(recepcionistas.get(i));
                                }
                            } else if (escolha == 3) {
                                System.out.print("Digite o ID da recepcionista: ");
                                int idBusca = scanner.nextInt();
                                scanner.nextLine();
                                Recepcionista recepcionista = repositorioRecepcionista.buscarRecepcionistaPorId(idBusca);
                                if (recepcionista != null) {
                                    System.out.println(recepcionista);
                                } else {
                                    System.out.println("Recepcionista não encontrada.");
                                }
                            } else if (escolha == 4) {
                                System.out.print("Digite o ID da recepcionista a editar: ");
                                int idEdit = scanner.nextInt();
                                scanner.nextLine();
                                Recepcionista recepcionista = repositorioRecepcionista.buscarRecepcionistaPorId(idEdit);
                                if (recepcionista != null) {
                                    System.out.print("Novo nome: ");
                                    String nome = scanner.nextLine();
                                    System.out.print("Novo CPF: ");
                                    String cpf = scanner.nextLine();
                                    System.out.print("Novo telefone: ");
                                    String telefone = scanner.nextLine();
                                    System.out.print("Novo email: ");
                                    String email = scanner.nextLine();
                                    System.out.print("Nova senha: ");
                                    String senhaRecep = scanner.nextLine();
                                    System.out.print("Novo turno: ");
                                    String turno = scanner.nextLine();
                            
                                    boolean camposVazios = nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() ||
                                                           email.isEmpty() || senhaRecep.isEmpty() || turno.isEmpty();

                                    if (camposVazios) {
                                        System.out.println("Preencha todos os campos obrigatorios para continuar");
                                        continue;
                                    }

                                    Recepcionista recepcionistaEditada = new Recepcionista(idEdit, nome, cpf, telefone, email, senhaRecep, turno);
                                    repositorioRecepcionista.editarRecepcionista(recepcionistaEditada);
                                    System.out.println("Recepcionista atualizado com sucesso");
                                } else {
                                    System.out.println("Recepcionista não encontrada.");
                                }
                            } else if (escolha == 5) {
                                System.out.print("Digite o ID da recepcionista a remover: ");
                                int idRemove = scanner.nextInt();
                                scanner.nextLine();
                                Recepcionista recepcionista = repositorioRecepcionista.buscarRecepcionistaPorId(idRemove);
                                if (recepcionista != null) {
                                    repositorioRecepcionista.removerRecepcionista(recepcionista);
                                    System.out.println("Recepcionista removida com sucesso!");
                                } else {
                                    System.out.println("Recepcionista não encontrada.");
                                }
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        }
                    } else if (entidade == 3) {
                        while (true) {
                            System.out.println("\nGerenciamento de Pacientes:");
                            System.out.println("1 - Cadastrar Paciente");
                            System.out.println("2 - Listar Todos os Pacientes");
                            System.out.println("3 - Buscar Paciente por ID");
                            System.out.println("4 - Editar Paciente");
                            System.out.println("5 - Remover Paciente");
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha uma opção: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha == 0) break;

                            if (escolha == 1) {
                                System.out.print("ID: ");
                                int pacienteIdNovo = scanner.nextInt(); // Renomeado para pacienteIdNovo
                                scanner.nextLine();
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
                                System.out.print("Telefone: ");
                                String telefone = scanner.nextLine();
                                System.out.print("Email: ");
                                String email = scanner.nextLine();
                                System.out.print("Senha: ");
                                String senhaPaciente = scanner.nextLine();

                                boolean camposVazios = nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() ||
                                                       email.isEmpty() || senhaPaciente.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios para continuar");
                                    continue;
                                }

                                Paciente paciente = new Paciente(pacienteIdNovo, nome, cpf, telefone, email, senhaPaciente);
                                repositorioPaciente.addPaciente(paciente);
                                System.out.println("Paciente cadastrado com sucesso!");
                            } else if (escolha == 2) {
                                ArrayList<Paciente> pacientes = repositorioPaciente.listarPacientes();
                                for (int i = 0; i < pacientes.size(); i++) {
                                    System.out.println(pacientes.get(i));
                                }
                            } else if (escolha == 3) {
                                System.out.print("Digite o ID do paciente: ");
                                int idBusca = scanner.nextInt();
                                scanner.nextLine();
                                Paciente paciente = repositorioPaciente.buscarPacientePorId(idBusca);
                                if (paciente != null) {
                                    System.out.println(paciente);
                                } else {
                                    System.out.println("Paciente não encontrado.");
                                }
                            } else if (escolha == 4) {
                                System.out.print("Digite o ID do paciente a editar: ");
                                int idEdit = scanner.nextInt();
                                scanner.nextLine();
                                Paciente paciente = repositorioPaciente.buscarPacientePorId(idEdit);
                                if (paciente != null) {
                                    System.out.print("Novo nome: ");
                                    String nome = scanner.nextLine();
                                    System.out.print("Novo CPF: ");
                                    String cpf = scanner.nextLine();
                                    System.out.print("Novo telefone: ");
                                    String telefone = scanner.nextLine();
                                    System.out.print("Novo email: ");
                                    String email = scanner.nextLine();
                                    System.out.print("Nova senha: ");
                                    String senhaPaciente = scanner.nextLine();

                                    boolean camposVazios = nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() ||
                                                           email.isEmpty() || senhaPaciente.isEmpty();

                                    if (camposVazios) {
                                        System.out.println("Preencha todos os campos para editar o paciente. Edição cancelada!");
                                        continue;
                                    }

                                    Paciente pacienteEditado = new Paciente(idEdit, nome, cpf, telefone, email, senhaPaciente);
                                    repositorioPaciente.editarPaciente(pacienteEditado);
                                    System.out.println("Paciente atualizado com sucesso");
                                } else {
                                    System.out.println("Paciente não encontrado.");
                                }
                            } else if (escolha == 5) {
                                System.out.print("Digite o ID do paciente a remover: ");
                                int idRemove = scanner.nextInt();
                                scanner.nextLine();
                                Paciente paciente = repositorioPaciente.buscarPacientePorId(idRemove);
                                if (paciente != null) {
                                    repositorioPaciente.removerPaciente(paciente);
                                    System.out.println("Paciente removido com sucesso!");
                                } else {
                                    System.out.println("Paciente não encontrado.");
                                }
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        }
                    } else if (entidade == 4) {
                        while (true) {
                            System.out.println("\nGerenciamento de Consultas:");
                            System.out.println("1 - Cadastrar Consulta");
                            System.out.println("2 - Listar Todas as Consultas");
                            System.out.println("3 - Buscar Consulta por ID");
                            System.out.println("4 - Editar Consulta");
                            System.out.println("5 - Remover Consulta");
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha uma opção: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha == 0) break;

                            if (escolha == 1) {
                                System.out.print("ID: ");
                                int id = scanner.nextInt();
                                System.out.print("ID do paciente: ");
                                int pacienteId = scanner.nextInt();
                                System.out.print("CRM do médico: ");
                                int crm = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Data da consulta (AAAA-MM-DD): ");
                                String dataStr = scanner.nextLine().replace(" ", "");

                                boolean camposVazios = dataStr.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios");
                                    continue;
                                }

                                Paciente paciente = repositorioPaciente.buscarPacientePorId(pacienteId);
                                Medico medico = repositorioMedico.buscarMedicoPorCrm(crm);

                                if (paciente == null || medico == null) {
                                    System.out.println("Paciente ou médico não encontrado.");
                                    continue;
                                }

                                Consulta consulta = new Consulta(id, paciente, medico, LocalDate.parse(dataStr));
                                repositorioConsulta.addConsulta(consulta);
                                System.out.println("Consulta agendada com sucesso!");
                            } else if (escolha == 2) {
                                ArrayList<Consulta> consultas = repositorioConsulta.listarConsultas();
                                for (int i = 0; i < consultas.size(); i++) {
                                    System.out.println(consultas.get(i));
                                }
                            } else if (escolha == 3) {
                                System.out.print("Digite o ID da consulta: ");
                                int idBusca = scanner.nextInt();
                                scanner.nextLine();
                                Consulta consulta = repositorioConsulta.buscarConsultaPorId(idBusca);
                                if (consulta != null) {
                                    System.out.println(consulta);
                                } else {
                                    System.out.println("Consulta não encontrada.");
                                }
                            } else if (escolha == 4) {
                                System.out.print("Digite o ID da consulta a editar: ");
                                int idEdit = scanner.nextInt();
                                System.out.print("ID do paciente: ");
                                int pacienteId = scanner.nextInt();
                                System.out.print("CRM do médico: ");
                                int crm = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nova data da consulta (AAAA-MM-DD): ");
                                String dataStr = scanner.nextLine();

                                boolean camposVazios = dataStr.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios para continuar");
                                    continue;
                                }

                                Paciente paciente = repositorioPaciente.buscarPacientePorId(pacienteId);
                                Medico medico = repositorioMedico.buscarMedicoPorCrm(crm);

                                if (paciente == null || medico == null) {
                                    System.out.println("Paciente ou médico não encontrado.");
                                    continue;
                                }

                                Consulta consultaEditada = new Consulta(idEdit, paciente, medico, LocalDate.parse(dataStr));
                                repositorioConsulta.editarConsulta(consultaEditada);
                                System.out.println("Consulta atualizada com sucesso");
                            } else if (escolha == 5) {
                                System.out.print("Digite o ID da consulta a remover: ");
                                int idRemove = scanner.nextInt();
                                scanner.nextLine();
                                Consulta consulta = repositorioConsulta.buscarConsultaPorId(idRemove);
                                if (consulta != null) {
                                    repositorioConsulta.removerConsulta(consulta);
                                    System.out.println("Consulta removida com sucesso!");
                                } else {
                                    System.out.println("Consulta não encontrada.");
                                }
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        }
                    } else if (entidade == 5) {
                        while (true) {
                            System.out.println("\nGerenciamento de Exames:");
                            System.out.println("1 - Cadastrar Exame");
                            System.out.println("2 - Listar Todos os Exames");
                            System.out.println("3 - Buscar Exame por ID");
                            System.out.println("4 - Editar Exame");
                            System.out.println("5 - Remover Exame");
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha uma opção: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha == 0) break;

                            if (escolha == 1) {
                                System.out.print("ID: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Tipo do exame: ");
                                String tipoExame = scanner.nextLine();
                                System.out.print("Data do exame (AAAA-MM-DD): ");
                                String dataStr = scanner.nextLine().replace(" ", "");
                                System.out.print("Resultado: ");
                                String resultado = scanner.nextLine();

                                boolean camposVazios = tipoExame.isEmpty() || dataStr.isEmpty() || resultado.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios para continuar");
                                    continue;
                                }

                                Exame exame = new Exame(id, tipoExame, LocalDate.parse(dataStr), resultado);
                                repositorioExame.addExame(exame);
                                System.out.println("Exame cadastrado com sucesso!");
                            } else if (escolha == 2) {
                                ArrayList<Exame> exames = repositorioExame.listarExames();
                                for (int i = 0; i < exames.size(); i++) {
                                    System.out.println(exames.get(i));
                                }
                            } else if (escolha == 3) {
                                System.out.print("Digite o ID do exame: ");
                                int idBusca = scanner.nextInt();
                                scanner.nextLine();
                                Exame exame = repositorioExame.buscarExamePorId(idBusca);
                                if (exame != null) {
                                    System.out.println(exame);
                                } else {
                                    System.out.println("Exame não encontrado.");
                                }
                            } else if (escolha == 4) {
                                System.out.print("Digite o ID do exame a editar: ");
                                int idEdit = scanner.nextInt();
                                scanner.nextLine();
                                Exame exame = repositorioExame.buscarExamePorId(idEdit);
                                if (exame != null) {
                                    System.out.print("Novo tipo do exame: ");
                                    String tipoExame = scanner.nextLine();
                                    System.out.print("Nova data do exame (AAAA-MM-DD): ");
                                    String dataStr = scanner.nextLine().replace(" ", "");
                                    System.out.print("Novo resultado: ");
                                    String resultado = scanner.nextLine();

                                    boolean camposVazios = tipoExame.isEmpty() || dataStr.isEmpty() || resultado.isEmpty();

                                    if (camposVazios) {
                                        System.out.println("Preencha todos os campos obrigatorios para continuar");
                                        continue;
                                    }

                                    Exame exameEditado = new Exame(idEdit, tipoExame, LocalDate.parse(dataStr), resultado);
                                    repositorioExame.editarExame(exameEditado);
                                    System.out.println("Exame atualizado com sucesso");
                                } else {
                                    System.out.println("Exame não encontrado.");
                                }
                            } else if (escolha == 5) {
                                System.out.print("Digite o ID do exame a remover: ");
                                int idRemove = scanner.nextInt();
                                scanner.nextLine();
                                Exame exame = repositorioExame.buscarExamePorId(idRemove);
                                if (exame != null) {
                                    repositorioExame.removerExame(exame);
                                    System.out.println("Exame removido com sucesso!");
                                } else {
                                    System.out.println("Exame não encontrado.");
                                }
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else {
                System.out.println("Senha inválida");
                return;
            }
        } else if (opcao == 2) {
            System.out.print("Digite o CRM do médico: ");
            int crm = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite a senha do médico: ");
            String senha = scanner.nextLine();

            RepositorioMedico repositorioMedico = new RepositorioMedico();
            Medico medico = repositorioMedico.buscarMedicoPorCrmESenha(crm, senha);

            if (medico != null) {
                System.out.println("\nBem-vindo ao sistema, Médico!");

                RepositorioExame repositorioExame = new RepositorioExame();

                while (true) {
                    System.out.println("\nGerenciamento de Exames:");
                    System.out.println("1 - Cadastrar Exame");
                    System.out.println("2 - Listar Todos os Exames");
                    System.out.println("3 - Buscar Exame por ID");
                    System.out.println("4 - Editar Exame");
                    System.out.println("5 - Remover Exame");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opção: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha == 0) {
                        System.out.println("Saindo do menu médico.");
                        break;
                    }

                    if (escolha == 1) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Tipo do exame: ");
                        String tipoExame = scanner.nextLine();
                        System.out.print("Data do exame (AAAA-MM-DD): ");
                        String dataStr = scanner.nextLine().replace(" ", "");
                        System.out.print("Resultado: ");
                        String resultado = scanner.nextLine();

                        Exame exame = new Exame(id, tipoExame, LocalDate.parse(dataStr), resultado);
                        repositorioExame.addExame(exame);
                        System.out.println("Exame cadastrado com sucesso!");
                    } else if (escolha == 2) {
                        for (Exame e : repositorioExame.listarExames()) {
                            System.out.println(e);
                        }
                    } else if (escolha == 3) {
                        System.out.print("Digite o ID do exame: ");
                        int idBusca = scanner.nextInt();
                        scanner.nextLine();
                        Exame exame = repositorioExame.buscarExamePorId(idBusca);
                        if (exame != null) {
                            System.out.println(exame);
                        } else {
                            System.out.println("Exame não encontrado.");
                        }
                    } else if (escolha == 4) {
                        System.out.print("Digite o ID do exame a editar: ");
                        int idEdit = scanner.nextInt();
                        scanner.nextLine();
                        Exame exame = repositorioExame.buscarExamePorId(idEdit);
                        if (exame != null) {
                            System.out.print("Novo tipo do exame: ");
                            String tipoExame = scanner.nextLine();
                            System.out.print("Nova data do exame (AAAA-MM-DD): ");
                            String dataStr = scanner.nextLine().replace(" ", "");
                            System.out.print("Novo resultado: ");
                            String resultado = scanner.nextLine();

                            Exame exameEditado = new Exame(idEdit, tipoExame, LocalDate.parse(dataStr), resultado);
                            repositorioExame.editarExame(exameEditado);
                            System.out.println("Exame atualizado com sucesso");
                        } else {
                            System.out.println("Exame não encontrado.");
                        }
                    } else if (escolha == 5) {
                        System.out.print("Digite o ID do exame a remover: ");
                        int idRemove = scanner.nextInt();
                        scanner.nextLine();
                        Exame exame = repositorioExame.buscarExamePorId(idRemove);
                        if (exame != null) {
                            repositorioExame.removerExame(exame);
                            System.out.println("Exame removido com sucesso!");
                        } else {
                            System.out.println("Exame não encontrado.");
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else {
                System.out.println("CRM ou senha inválidos.");
                return;
            }
        } else if (opcao == 3) {
            System.out.print("Digite o ID do recepcionista: ");
            int idRecepcionista = scanner.nextInt(); // Renomeado para evitar conflito
            scanner.nextLine();
            System.out.print("Digite a senha do recepcionista: ");
            String senha = scanner.nextLine();

            RepositorioRecepcionista repositorioRecepcionista = new RepositorioRecepcionista();
            Recepcionista recepcionista = repositorioRecepcionista.buscarRecepcionistaPorIdESenha(idRecepcionista, senha);

            if (recepcionista != null) {
                System.out.println("\nBem-vindo ao sistema, Recepcionista!");

                RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
                RepositorioConsulta repositorioConsulta = new RepositorioConsulta();
                RepositorioMedico repositorioMedico = new RepositorioMedico();

                while (true) {
                    System.out.println("\nO que deseja gerenciar?");
                    System.out.println("1 - Pacientes");
                    System.out.println("2 - Consultas");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opção: ");
                    int entidade = scanner.nextInt();
                    scanner.nextLine();

                    if (entidade == 0) {
                        System.out.println("Saindo do menu recepcionista.");
                        break;
                    }

                    if (entidade == 1) {
                        while (true) {
                            System.out.println("\nGerenciamento de Pacientes:");
                            System.out.println("1 - Cadastrar Paciente");
                            System.out.println("2 - Listar Todos os Pacientes");
                            System.out.println("3 - Buscar Paciente por ID");
                            System.out.println("4 - Editar Paciente");
                            System.out.println("5 - Remover Paciente");
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha uma opção: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha == 0) break;

                            if (escolha == 1) {
                                System.out.print("ID: ");
                                int pacienteIdNovo = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
                                System.out.print("Telefone: ");
                                String telefone = scanner.nextLine();
                                System.out.print("Email: ");
                                String email = scanner.nextLine();
                                System.out.print("Senha: ");
                                String senhaPaciente = scanner.nextLine();

                                boolean camposVazios = nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() ||
                                                       email.isEmpty() || senhaPaciente.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios para continuar");
                                    continue;
                                }

                                Paciente paciente = new Paciente(pacienteIdNovo, nome, cpf, telefone, email, senhaPaciente);
                                repositorioPaciente.addPaciente(paciente);
                                System.out.println("Paciente cadastrado com sucesso!");
                            } else if (escolha == 2) {
                                ArrayList<Paciente> pacientes = repositorioPaciente.listarPacientes();
                                for (int i = 0; i < pacientes.size(); i++) {
                                    System.out.println(pacientes.get(i));
                                }
                            } else if (escolha == 3) {
                                System.out.print("Digite o ID do paciente: ");
                                int idBusca = scanner.nextInt();
                                scanner.nextLine();
                                Paciente paciente = repositorioPaciente.buscarPacientePorId(idBusca);
                                if (paciente != null) {
                                    System.out.println(paciente);
                                } else {
                                    System.out.println("Paciente não encontrado.");
                                }
                            } else if (escolha == 4) {
                                System.out.print("Digite o ID do paciente a editar: ");
                                int idEdit = scanner.nextInt();
                                scanner.nextLine();
                                Paciente paciente = repositorioPaciente.buscarPacientePorId(idEdit);
                                if (paciente != null) {
                                    System.out.print("Novo nome: ");
                                    String nome = scanner.nextLine();
                                    System.out.print("Novo CPF: ");
                                    String cpf = scanner.nextLine();
                                    System.out.print("Novo telefone: ");
                                    String telefone = scanner.nextLine();
                                    System.out.print("Novo email: ");
                                    String email = scanner.nextLine();
                                    System.out.print("Nova senha: ");
                                    String senhaPaciente = scanner.nextLine();

                                    boolean camposVazios = nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() ||
                                                           email.isEmpty() || senhaPaciente.isEmpty();

                                    if (camposVazios) {
                                        System.out.println("Preencha todos os campos para editar o paciente. Edição cancelada!");
                                        continue;
                                    }

                                    Paciente pacienteEditado = new Paciente(idEdit, nome, cpf, telefone, email, senhaPaciente);
                                    repositorioPaciente.editarPaciente(pacienteEditado);
                                    System.out.println("Paciente atualizado com sucesso");
                                } else {
                                    System.out.println("Paciente não encontrado.");
                                }
                            } else if (escolha == 5) {
                                System.out.print("Digite o ID do paciente a remover: ");
                                int idRemove = scanner.nextInt();
                                scanner.nextLine();
                                Paciente paciente = repositorioPaciente.buscarPacientePorId(idRemove);
                                if (paciente != null) {
                                    repositorioPaciente.removerPaciente(paciente);
                                    System.out.println("Paciente removido com sucesso!");
                                } else {
                                    System.out.println("Paciente não encontrado.");
                                }
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        }
                    } else if (entidade == 2) {
                        while (true) {
                            System.out.println("\nGerenciamento de Consultas:");
                            System.out.println("1 - Cadastrar Consulta");
                            System.out.println("2 - Listar Todas as Consultas");
                            System.out.println("3 - Buscar Consulta por ID");
                            System.out.println("4 - Editar Consulta");
                            System.out.println("5 - Remover Consulta");
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha uma opção: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha == 0) break;

                            if (escolha == 1) {
                                System.out.print("ID: ");
                                int id = scanner.nextInt();
                                System.out.print("ID do paciente: ");
                                int pacienteId = scanner.nextInt();
                                System.out.print("CRM do médico: ");
                                int crm = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Data da consulta (AAAA-MM-DD): ");
                                String dataStr = scanner.nextLine().replace(" ", "");

                                boolean camposVazios = dataStr.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios");
                                    continue;
                                }

                                Paciente paciente = repositorioPaciente.buscarPacientePorId(pacienteId);
                                Medico medico = repositorioMedico.buscarMedicoPorCrm(crm);

                                if (paciente == null || medico == null) {
                                    System.out.println("Paciente ou médico não encontrado.");
                                    continue;
                                }

                                Consulta consulta = new Consulta(id, paciente, medico, LocalDate.parse(dataStr));
                                repositorioConsulta.addConsulta(consulta);
                                System.out.println("Consulta agendada com sucesso!");
                            } else if (escolha == 2) {
                                ArrayList<Consulta> consultas = repositorioConsulta.listarConsultas();
                                for (int i = 0; i < consultas.size(); i++) {
                                    System.out.println(consultas.get(i));
                                }
                            } else if (escolha == 3) {
                                System.out.print("Digite o ID da consulta: ");
                                int idBusca = scanner.nextInt();
                                scanner.nextLine();
                                Consulta consulta = repositorioConsulta.buscarConsultaPorId(idBusca);
                                if (consulta != null) {
                                    System.out.println(consulta);
                                } else {
                                    System.out.println("Consulta não encontrada.");
                                }
                            } else if (escolha == 4) {
                                System.out.print("Digite o ID da consulta a editar: ");
                                int idEdit = scanner.nextInt();
                                System.out.print("ID do paciente: ");
                                int pacienteId = scanner.nextInt();
                                System.out.print("CRM do médico: ");
                                int crm = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nova data da consulta (AAAA-MM-DD): ");
                                String dataStr = scanner.nextLine();

                                boolean camposVazios = dataStr.isEmpty();

                                if (camposVazios) {
                                    System.out.println("Preencha todos os campos obrigatorios para continuar");
                                    continue;
                                }

                                Paciente paciente = repositorioPaciente.buscarPacientePorId(pacienteId);
                                Medico medico = repositorioMedico.buscarMedicoPorCrm(crm);

                                if (paciente == null || medico == null) {
                                    System.out.println("Paciente ou médico não encontrado.");
                                    continue;
                                }

                                Consulta consultaEditada = new Consulta(idEdit, paciente, medico, LocalDate.parse(dataStr));
                                repositorioConsulta.editarConsulta(consultaEditada);
                                System.out.println("Consulta atualizada com sucesso");
                            } else if (escolha == 5) {
                                System.out.print("Digite o ID da consulta a remover: ");
                                int idRemove = scanner.nextInt();
                                scanner.nextLine();
                                Consulta consulta = repositorioConsulta.buscarConsultaPorId(idRemove);
                                if (consulta != null) {
                                    repositorioConsulta.removerConsulta(consulta);
                                    System.out.println("Consulta removida com sucesso!");
                                } else {
                                    System.out.println("Consulta não encontrada.");
                                }
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else {
                System.out.println("Senha inválida");
                return;
            }
        } else if (opcao == 4) {
            System.out.print("Digite o ID do paciente: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite a senha do paciente: ");
            String senha = scanner.nextLine();

            RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
            Paciente paciente = repositorioPaciente.buscarPacientePorIdESenha(id, senha);

            if (paciente != null) {
                System.out.println("\nBem-vindo ao sistema, Paciente!");

                RepositorioConsulta repositorioConsulta = new RepositorioConsulta();
                RepositorioExame repositorioExame = new RepositorioExame();

                while (true) {
                    System.out.println("\nMenu Paciente:");
                    System.out.println("1 - Listar Todas as Consultas");
                    System.out.println("2 - Listar Todos os Exames");
                    System.out.println("3 - Buscar Consulta por ID");
                    System.out.println("4 - Buscar Exame por ID");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opção: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha == 1) {
                        System.out.println("Consultas:");
                        for (Consulta c : repositorioConsulta.listarConsultas()) {
                            System.out.println(c);
                        }
                    } else if (escolha == 2) {
                        System.out.println("Exames:");
                        for (Exame e : repositorioExame.listarExames()) {
                            System.out.println(e);
                        }
                    } else if (escolha == 3) {
                        System.out.print("Digite o ID da consulta: ");
                        int idConsulta = scanner.nextInt();
                        scanner.nextLine();
                        Consulta consulta = repositorioConsulta.buscarConsultaPorId(idConsulta);
                        if (consulta != null) {
                            System.out.println("Consulta encontrada: " + consulta);
                        } else {
                            System.out.println("Consulta não encontrada para o ID informado.");
                        }
                    } else if (escolha == 4) {
                        System.out.print("Digite o ID do exame: ");
                        int idExame = scanner.nextInt();
                        scanner.nextLine();
                        Exame exame = repositorioExame.buscarExamePorId(idExame);
                        if (exame != null) {
                            System.out.println("Exame encontrado: " + exame);
                        } else {
                            System.out.println("Exame não encontrado para o ID informado.");
                        }
                    } else if (escolha == 0) {
                        System.out.println("Saindo do menu paciente.");
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else {
                System.out.println("ID ou senha inválidos.");
                return;
            }
        } else {
            System.out.println("Opção inválida!");
            return;
        }
     }
}    
    
