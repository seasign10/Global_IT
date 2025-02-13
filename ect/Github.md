# Github

- **window** 환경에서 `git bash` 설치  : https://git-scm.com/downloads
  - Mac에서는 Terminal이 git과 호환되기 때문에 `git bash` 설치 필요 X
  - 대신 `homebrew` 명령어 설치 후 git을 설치해야 함



### :black_circle: github 계정 등록

```bash
$ git config --global user.name "Your Name"         // 사용자 이름
$ git config --global user.email "you@example.com"  // 사용자 이메일 주소
```

- 등록된 계정을 지우려면 윈도우 `자격증명` 에 들어가서 지울 수 있다.



> **repo 등록 순서**
>
> 1. `git init` - 폴더에 git 부여
> 2. `git remote` - 로컬에서 github 주소와 연결
> 3. `git add` - 수정 사항 등록
> 4. `git commit` - 등록된 수정사항 log에 기록
>    - commit 이름은 규칙을 정해서 한다.
>    - 대체로 `add: mainpage` `edit: detail.html` 등으로 사용
> 5. `git push` - 적용된 commit 을 repo에 올림

- repository를 연결하고 난 이후에는 3~5번 과정만 반복하면 된다.



**유용한 명령어**

```bash
$ git status # 변경사항의 파일들이 add가 되었는지 안되었는지 확인 가능

$ git log # commit의 log를 확인할 수 있음, 나올 때는 q를 입력하면 됨

$ git clone 깃주소 # 깃주소의 파일들을 내려받을 수 있다. git이 꼬여서 어떤 오류로도 해결할 수 없을 때는 현재 파일을 따로 백업해두고 다시 내려받는 것을 권장

$ git pull 브랜치이름 # 변경사항이 있는 repo를 내려받을 수 있다. 
```

- `git pull` 주의사항
  1. 내려받을 시, 브랜치이름을 작성하지 않으면 기본값인 defualt branch `master`|`main` 에서 내려받아 진다. 필요에 따라 꼭 기재하도록 하자.
  2. 현재 나의 로컬 파일 변경사항이 있을 때는 변경된 다른 사람의 코드와 충돌이 날 수 있음
     - `pull`로 내려받을 때는 `push`와 병합(merge)까지 한 다음에 내려받을 것



#### :warning: 충돌(conflict)

- 같은 파일을 수정하게 되면 <u>\*Merge(병합)</u>시 Conflic(충돌)가 발생하므로 주의

\***Merge** : 변경사항이 있는 로컬 파일을 repository의 파일과 합치는 과정

- 개인 repo에서는 상황에 따라 바로 push가 가능하지만(`main` | `master`) 협업 시에는 사용자의 파일 변경사항에 대한 Merge 작업이 따로 필요함
- 충돌과 파일 훼손을 막기위해 `branch` 를 만들어 git을 관리함



#### :seedling: Branch

```bash
$ git checkout -b 브랜치이름 # "브랜치이름" 생성 후 "브랜치이름"으로 이동
$ git checkout 브랜치이름 # 존재하는 "브랜치이름" 으로 이동
$ git branch 브랜치이름 # "브랜치이름" 생성
$ git branch -m 새_브랜치이름 # 현재의 브랜치 이름을 새_브랜치이름 으로 변경
$ git branch -d 삭제할_브랜치이름
```

- 브랜치명은 `feature/작업중인 페이지 or 기술` 를 자주 사용 

- 공백 하나라도 변경시에는 수정 파일로 접수되어 `add`를 해야 `commit`과 `push`를 할 수 있다. 

  - 그러므로 본인이 사용하는 브랜치로 제대로 이동되어있는지 반드시 확인하고 작업을 수행할 것

- 자신의 브랜치에서 작업하고, `dev` 브랜치에 `push` 하는 것을 권장

  - **defualt branch** (`master` | `main`)에는 <u>최종 배포 결과물</u>만 병합해서 올린다.

  - `dev` 브랜치는 개발중인 브랜치들을 병합하는데 사용된다.
    즉,

    > `master|main` (default branch)
    >
    > `dev`
    >
    > `각자의 브랜치`

    로 구성되며, 작업중인 브랜치의 기능이 끝나면 또 다른 작업 브랜치를 만들어서 파트 구분을 명확히 하도록 한다.



> **master? main? branch?**
>
> - `git init`으로 폴더에 git을 사용할 수 있는 상태를 부여하면 `master`로 시작한다. (defalt branch)
>   (`.git`이라는 폴더도 생성된다. git을 초기화 하고 싶을 때는 해당 폴더를 삭제하면 됨)
>
> - `master`는 repo의 본체, `branch`는 master의 복제본이라고 생각하면 편함
>   즉, `master`에서 뻗어나온 복제본
>
> - 요즘에는 defalt branch를 `master`보다  `main`으로 더 많이 사용한다.
>
>   - `master`의 위치에서 브랜치 이름 바꾸는 명령어를 사용하면 `master`의 이름을 바꿀 수 있다.
>
>   ```bash
>   $ git branch -m main # 브랜치 이름을 main으로 변경
>   ```

