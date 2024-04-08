package com.example.gasstation.loader;

import com.example.gasstation.model.Branch;
import com.example.gasstation.repository.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BranchLoader implements ApplicationRunner {
    private final BranchRepository branchRepository;

    private void loadBranches() {
        Branch branch1 = new Branch();
        branch1.setName("АЗС 12");
        branch1.setAddress("Москва, Котельническая наб., 1/15с10");

        Branch branch2 = new Branch();
        branch2.setName("АЗС 43");
        branch2.setAddress("Москва, Волжский б-р, 51 строение 1");

        Branch branch3 = new Branch();
        branch3.setName("АЗС 4");
        branch3.setAddress("Москва, ул. Берзарина, 26, корп. 1");

        Branch branch4 = new Branch();
        branch4.setName("АЗС 11");
        branch4.setAddress("Санкт-Петербург, Советский просп., 59");

        Branch branch5 = new Branch();
        branch5.setName("АЗС 32");
        branch5.setAddress("Санкт-Петербург, Витебский пр., 1Б");

        Branch branch6 = new Branch();
        branch6.setName("АЗС 65");
        branch6.setAddress("Санкт-Петербург, Партизанская ул., 17А");

        branchRepository.save(branch1);
        branchRepository.save(branch2);
        branchRepository.save(branch3);
        branchRepository.save(branch4);
        branchRepository.save(branch5);
        branchRepository.save(branch6);
    }

    public void run(ApplicationArguments args) {
        loadBranches();
    }
}
