package com.koldex.seach;

import com.koldex.seach.domain.entity.Area;
import com.koldex.seach.domain.entity.Candidato;
import com.koldex.seach.domain.entity.Curso;
import com.koldex.seach.repository.AreaRepository;
import com.koldex.seach.repository.CandidatoRepository;
import com.koldex.seach.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class TagCommandLineRunner implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final CursoRepository cursoRepository;
    private final CandidatoRepository candidatoRepository;

    @Override
    public void run(String... args) throws Exception {
        // --- ÁREAS ---
        Area ti = new Area();
        ti.setNome("Tecnologia da Informação");
        ti.setIndMatutino(true);
        ti.setIndVespertino(true);
        ti.setIndNoturno(false);
        ti.setDataRegistro(LocalDateTime.now());

        Area saude = new Area();
        saude.setNome("Saúde");
        saude.setIndMatutino(true);
        saude.setIndVespertino(false);
        saude.setIndNoturno(true);
        saude.setDataRegistro(LocalDateTime.now());

        Area engenharias = new Area();
        engenharias.setNome("Engenharias");
        engenharias.setIndMatutino(true);
        engenharias.setIndVespertino(true);
        engenharias.setIndNoturno(true);
        engenharias.setDataRegistro(LocalDateTime.now());

        Area direito = new Area();
        direito.setNome("Direito");
        direito.setIndMatutino(false);
        direito.setIndVespertino(true);
        direito.setIndNoturno(true);
        direito.setDataRegistro(LocalDateTime.now());

        Area educacao = new Area();
        educacao.setNome("Educação");
        educacao.setIndMatutino(true);
        educacao.setIndVespertino(false);
        educacao.setIndNoturno(false);
        educacao.setDataRegistro(LocalDateTime.now());

        areaRepository.saveAll(Arrays.asList(ti, saude, engenharias, direito, educacao));

        // --- CURSOS ---
        Curso cc = new Curso();
        cc.setNome("Ciência da Computação");
        cc.setArea(ti);

        Curso es = new Curso();
        es.setNome("Engenharia de Software");
        es.setArea(ti);

        Curso si = new Curso();
        si.setNome("Sistemas de Informação");
        si.setArea(ti);

        Curso medicina = new Curso();
        medicina.setNome("Medicina");
        medicina.setArea(saude);

        Curso enfermagem = new Curso();
        enfermagem.setNome("Enfermagem");
        enfermagem.setArea(saude);

        Curso odontologia = new Curso();
        odontologia.setNome("Odontologia");
        odontologia.setArea(saude);

        Curso engCivil = new Curso();
        engCivil.setNome("Engenharia Civil");
        engCivil.setArea(engenharias);

        Curso engEletrica = new Curso();
        engEletrica.setNome("Engenharia Elétrica");
        engEletrica.setArea(engenharias);

        Curso engMecanica = new Curso();
        engMecanica.setNome("Engenharia Mecânica");
        engMecanica.setArea(engenharias);

        Curso dirConst = new Curso();
        dirConst.setNome("Direito Constitucional");
        dirConst.setArea(direito);

        Curso dirPenal = new Curso();
        dirPenal.setNome("Direito Penal");
        dirPenal.setArea(direito);

        Curso pedagogia = new Curso();
        pedagogia.setNome("Pedagogia");
        pedagogia.setArea(educacao);

        Curso educFisica = new Curso();
        educFisica.setNome("Educação Física");
        educFisica.setArea(educacao);

        cursoRepository.saveAll(Arrays.asList(cc, es, si, medicina, enfermagem, odontologia,
                engCivil, engEletrica, engMecanica, dirConst, dirPenal, pedagogia, educFisica));

        // --- CANDIDATOS ---
        Candidato joao = new Candidato();
        joao.setNome("João Silva");
        joao.setCpf("87399904006");
        joao.setPcd(false);
        joao.setIsValid(false);
        joao.setCurso(cc);

        Candidato maria = new Candidato();
        maria.setNome("Maria Souza");
        maria.setCpf("90403458056");
        maria.setPcd(true);
        maria.setIsValid(false);
        maria.setCurso(es);

        Candidato carlos = new Candidato();
        carlos.setNome("Carlos Pereira");
        carlos.setCpf("81595507078");
        carlos.setPcd(false);
        carlos.setIsValid(false);
        carlos.setCurso(si);

        Candidato ana = new Candidato();
        ana.setNome("Ana Costa");
        ana.setCpf("70942091000");
        ana.setPcd(true);
        ana.setIsValid(true);
        ana.setCurso(medicina);

        // ... Continue para todos os candidatos

        candidatoRepository.saveAll(Arrays.asList(joao, maria, carlos, ana /*, demais candidatos */));
    }
}
