import {Directive,ElementRef} from "@angular/core";

@Directive({selector:'[changecolor]'})

export class ChangeColorDirectives{

constructor(er:ElementRef){

er.nativeElement.style.color="green";

}

}