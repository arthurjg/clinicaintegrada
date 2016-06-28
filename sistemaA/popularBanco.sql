
--insere pacientes
INSERT INTO paciente(id, endereco, nome) VALUES (1, 'Rua Joao Jose Barcelos 356', 'Joao Silva');
INSERT INTO paciente(id, endereco, nome) VALUES (2, 'Rua Mariano Silva 125', 'Augusto Santos');
INSERT INTO paciente(id, endereco, nome) VALUES (3, 'Rua Jose Cosme Pamplona 233', 'Maria Auxiliadora');
INSERT INTO paciente(id, endereco, nome) VALUES (4, 'Rua Santa Luzia', 'Joana Alves');

--insere clinica_servico
INSERT INTO clinica_servico(id, caminhocontexto, caminhorecurso, dominio, exameparametro, pacienteparametro, porta)
    VALUES (1, 'clinicaA-WS', 'rest/clinica/exames/paciente/{paciente}/exame/{exame}', 'localhost', 'exame', 'paciente', '8080');
	
INSERT INTO clinica_servico(id, caminhocontexto, caminhorecurso, dominio, exameparametro, pacienteparametro, porta)
    VALUES (2, 'clinicaB-WS', 'rest/servico/exames/paciente/exame/{paciente}/{exame}', 'localhost', 'exame', 'paciente', '8080');
	
INSERT INTO clinica_servico(id, caminhocontexto, caminhorecurso, dominio, exameparametro, pacienteparametro, porta)
    VALUES (3, 'clinicaC-WS', 'rest/exames/codigo/{pacienteCodigo}/{exameCodigo}', 'localhost', 'exameCodigo', 'pacienteCodigo', '8080');

--insere clinica_cliente
INSERT INTO clinica_cliente(id, caminhocontexto, caminhovisualizador, contextoservicoparametro, 
							dominio, dominioservicoparametro, exameparametronome, exameparametrovalor, 
							pacienteparametronome, pacienteparametrovalor, porta, portaservicoparametro, 
							recursoservicoparametro)
    VALUES (1, 'visualizador-img-web', 'exames.jsf', 'contextoRest', 
            'localhost', 'dominioRest', 'exameParametro', 'exameCodigo', 
            'pacienteParametro', 'pacienteCodigo', '8080', 'portaRest', 
            'recursoRest');

--insere clinicas
INSERT INTO clinica(id, endereco, nome, clinicaservico_id, clinicacliente_id) VALUES (1, 'Rua Jose Cosme Pamplona 999', 'Clinica Medica A', 1, 1);
INSERT INTO clinica(id, endereco, nome, clinicaservico_id, clinicacliente_id) VALUES (2, 'Rua Mariano Silva 100', 'Clinica Medica B', 2, 1);
INSERT INTO clinica(id, endereco, nome, clinicaservico_id, clinicacliente_id) VALUES (3, 'Rua Joao Jose Barcelos 555', 'Clinica Medica C', 3, 1);

--insere exames
INSERT INTO exame(id, nome, solicitante, clinica_id, paciente_id) VALUES (1, 'Holter', 'Dr. Anizio Teixeira', 1, 1);
INSERT INTO exame(id, nome, solicitante, clinica_id, paciente_id) VALUES (2, 'Raios X', 'Dr. Osmar Antunes', 1, 1);
INSERT INTO exame(id, nome, solicitante, clinica_id, paciente_id) VALUES (3, 'Tomografia Computadorizada', 'Dr. Aluizio Azevedo', 2, 2);
INSERT INTO exame(id, nome, solicitante, clinica_id, paciente_id) VALUES (4, 'Eletrocardiograma', 'Dr. Anizio Teixeira', 2, 3);
INSERT INTO exame(id, nome, solicitante, clinica_id, paciente_id) VALUES (5, 'Raios X', 'Dr. Carlos Gomes', 3, 4);
INSERT INTO exame(id, nome, solicitante, clinica_id, paciente_id) VALUES (6, 'Holter', 'Dr. Mario Cherem', 3, 2);
INSERT INTO exame(id, nome, solicitante, clinica_id, paciente_id) VALUES (7, 'Eletrocardiograma', 'Dra. Anastacia Dias', 2, 4);
INSERT INTO exame(id, nome, solicitante, clinica_id, paciente_id) VALUES (8, 'Ultrassonografia', 'Dr. Luciano Teodoro', 3, 3);