import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { ServiceComponent } from './service/service.component';
import { DataService } from './data.service';
import { DirectiveComponent } from './directive/directive.component';
import { ChangeColorDirectives } from './ChangeColorDirectives';
import { HighLightDirective } from './HighLightDirective';
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    ServiceComponent,
    DirectiveComponent,
    ChangeColorDirectives,
    HighLightDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [DataService],//registered service
  bootstrap: [AppComponent]
})
export class AppModule { }
